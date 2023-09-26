package back;

import assembly.*;
import assembly.inst.*;
import assembly.operand.*;

import java.util.*;

public class modernAllocator {
    public ASMModule module;

    ASMFunction curFunc;
    //图染色种数
    public static int colorNum = 27;
    PhysicsReg RegSp = PhysicsReg.regMap.get("sp");

    public LinkedHashSet<Reg> preColored = new LinkedHashSet<Reg>(PhysicsReg.regMap.values());
    public LinkedHashSet<Reg> initial = new LinkedHashSet<Reg>();
    public LinkedList<Reg> simplifyWorkList = new LinkedList<Reg>();
    public LinkedList<Reg> freezeWorkList = new LinkedList<Reg>();
    public LinkedList<Reg> spillWorkList = new LinkedList<Reg>();
    public LinkedHashSet<Reg> spilledNodes = new LinkedHashSet<Reg>();
    public LinkedHashSet<Reg> coalescedNodes = new LinkedHashSet<Reg>();
    public LinkedHashSet<Reg> coloredNodes = new LinkedHashSet<Reg>();
    public Stack<Reg> selectStack = new Stack<Reg>();

    public LinkedHashSet<ASMMvInst> coalescedMoves = new LinkedHashSet<>();
    public LinkedHashSet<ASMMvInst> constrainedMoves = new LinkedHashSet<>();
    public LinkedHashSet<ASMMvInst> frozenMoves = new LinkedHashSet<>();
    public LinkedHashSet<ASMMvInst> workListMoves = new LinkedHashSet<>();
    public LinkedHashSet<ASMMvInst> activeMoves = new LinkedHashSet<>();

    public static class Edge {
        public Reg u, v;
        public Edge(Reg u, Reg v) {
            this.u = u;
            this.v = v;
        }
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Edge e)) return false;
            return (u == e.u && v == e.v) || (u == e.v && v == e.u);
        }
        @Override
        public int hashCode() {
            return u.hashCode() ^ v.hashCode();
        }
    }

    public HashSet<Edge> adjSet = new HashSet<>();
    public HashMap<Reg, HashSet<Reg>> adjList = new HashMap<>();
    public HashMap<Reg, Integer> degree = new HashMap<>();
    public HashMap<Reg, HashSet<ASMMvInst>> moveList = new HashMap<>();
    public HashMap<Reg, Reg> alias = new HashMap<>();
    public HashMap<Reg, Integer> color = new HashMap<>();
    public HashSet<Reg> spillTemp = new HashSet<>();

    public modernAllocator(ASMModule module) {
        this.module = module;
    }

    public void work() {
        for (var func : module.functions)
            workOnFunc(func);
        Stackallocator();
    }

    LinkedList<ASMInst> newInsts;
    void workOnFunc(ASMFunction func) {
        curFunc = func;
        spillTemp.clear();
        while (true) {
            new LiveAnalysis(func).work();
            initAll(func);
            Build(func);
            MakeWorklist();
            boolean flag;
            while(true){
                flag = false;
                if (!simplifyWorkList.isEmpty()){
                    Simplify();
                    flag = true;
                }
                else if (!workListMoves.isEmpty()){
                    Coalesce();
                    flag = true;
                }
                else if (!freezeWorkList.isEmpty()){
                    Freeze();
                    flag = true;
                }
                else if (!spillWorkList.isEmpty()){
                    SelectSpill();
                    flag = true;
                }
                if(!flag)break;
            }
            AssignColors();
            if (spilledNodes.isEmpty()) break;
            RewriteProgram(func);
        }
        instchange(func);
    }
    void instchange(ASMFunction func){
        for (var block : func.blocks) {
            newInsts = new LinkedList<>();
            for (ASMInst inst : block.insts) {
                if (inst instanceof ASMLiInst && ((ASMLiInst) inst).pseudoImm instanceof stackImm) ((stackImm) ((ASMLiInst) inst).pseudoImm).calc();
                if (inst.rd instanceof VirtualReg) inst.rd = PhysicsReg.idReg.get(color.get(inst.rd));
                if (inst.rs1 instanceof VirtualReg) inst.rs1 = PhysicsReg.idReg.get(color.get(inst.rs1));
                if (inst.rs2 instanceof VirtualReg) inst.rs2 = PhysicsReg.idReg.get(color.get(inst.rs2));
                if (!(inst instanceof ASMMvInst) || inst.rd != inst.rs1) newInsts.add(inst);
            }
            block.insts = newInsts;
        }
    }

    void initclear(){
        initial.clear();
        simplifyWorkList.clear();
        freezeWorkList.clear();
        spillWorkList.clear();
        spilledNodes.clear();
        coalescedNodes.clear();
        coloredNodes.clear();
        selectStack.clear();

        coalescedMoves.clear();
        constrainedMoves.clear();
        frozenMoves.clear();
        workListMoves.clear();
        activeMoves.clear();

        adjSet.clear();
        adjList.clear();
        degree.clear();
        moveList.clear();
        alias.clear();
        color.clear();
    }
    void initAll(ASMFunction func) {
        initclear();
        for (var reg : PhysicsReg.regMap.values()) {
            adjList.put(reg, new HashSet<>());
            degree.put(reg, Integer.MAX_VALUE);
            moveList.put(reg, new HashSet<>());
            alias.put(reg, null);
            color.put(reg, reg.id);
            reg.spillWeight = 0;
        }
        for (var block : func.blocks)
            for (var inst : block.insts) {
                initial.addAll(inst.getDef());
                initial.addAll(inst.getUse());
            }
        initial.removeAll(preColored);
        for (var reg : initial) {
            adjList.put(reg, new HashSet<>());
            degree.put(reg, 0);
            moveList.put(reg, new HashSet<>());
            alias.put(reg, null);
            color.put(reg, null);
            reg.spillWeight = 0;
        }

        // compute spill weight
        for (var block : func.blocks) {
            double weight = Math.pow(10, block.loopDepth);
            for (var inst : block.insts) {
                for (var reg : inst.getDef()) reg.spillWeight += weight;
                for (var reg : inst.getUse()) reg.spillWeight += weight;
            }
        }
    }

    void Build(ASMFunction func) {//建立干涉图
        for (var block : func.blocks) {
            LinkedHashSet<Reg> live = new LinkedHashSet<>(block.liveOut);
            for (int i = block.insts.size() - 1; i >= 0; i--) {
                ASMInst inst = block.insts.get(i);
                if (inst instanceof ASMMvInst) {
                    live.removeAll(inst.getUse());
                    for (var reg : inst.getDef()) moveList.get(reg).add((ASMMvInst) inst);
                    for (var reg : inst.getUse()) moveList.get(reg).add((ASMMvInst) inst);
                    workListMoves.add((ASMMvInst) inst);
                }
                live.addAll(inst.getDef());

                for (Reg def : inst.getDef())
                    for (var l : live)
                        addEdge(def, l);
                live.removeAll(inst.getDef());
                live.addAll(inst.getUse());
            }
        }
    }
    void addEdge(Reg u, Reg v) {
        Edge e = new Edge(u, v);
        if (u == v || adjSet.contains(e)) return;
        adjSet.add(e);
        if (!preColored.contains(u)) {
            adjList.get(u).add(v);
            degree.put(u, degree.get(u) + 1);
        }
        if (!preColored.contains(v)) {
            adjList.get(v).add(u);
            degree.put(v, degree.get(v) + 1);
        }
    }
    void MakeWorklist() {
        for (var reg : initial) {
            if (degree.get(reg) >= colorNum) spillWorkList.add(reg);
            else if (moveRelated(reg)) freezeWorkList.add(reg);
            else simplifyWorkList.add(reg);
        }
        initial.clear();
    }
    LinkedHashSet<Reg> adjacent(Reg reg) {
        LinkedHashSet<Reg> ret = new LinkedHashSet<>(adjList.get(reg));
        selectStack.forEach(ret::remove);
        ret.removeAll(coalescedNodes);
        return ret;
    }
    LinkedHashSet<ASMMvInst> nodeMoves(Reg reg) {
        LinkedHashSet<ASMMvInst> ret = new LinkedHashSet<ASMMvInst>(activeMoves);
        ret.addAll(workListMoves);
        ret.retainAll(moveList.get(reg));
        return ret;
    }

    boolean moveRelated(Reg reg) {
        return !nodeMoves(reg).isEmpty();
    }
    void Simplify() {
        while (!simplifyWorkList.isEmpty()) {
            Reg n = simplifyWorkList.removeFirst();
            selectStack.push(n);
            for (var m : adjacent(n))
                DecrementDegree(m);
        }
    }
    void DecrementDegree(Reg reg) {
        int d = degree.get(reg);
        degree.put(reg, d - 1);
        if (d == colorNum) {
            LinkedHashSet<Reg> nodes = adjacent(reg);
            nodes.add(reg);
            enableMoves(nodes);
            spillWorkList.remove(reg);
            if (moveRelated(reg)) freezeWorkList.add(reg);
            else simplifyWorkList.add(reg);
        }
    }

    void enableMoves(LinkedHashSet<Reg> nodes) {
        for (var reg : nodes) {
            var nodeMoves = nodeMoves(reg);
            for (var mv : nodeMoves)
                if (activeMoves.contains(mv)) {
                    activeMoves.remove(mv);
                    workListMoves.add(mv);
                }
        }
    }
    void Coalesce() {
        ASMMvInst mv = workListMoves.iterator().next();
        Reg x = GetAlias(mv.rd), y = GetAlias(mv.rs1);
        Edge e = preColored.contains(y) ? new Edge(y, x) : new Edge(x, y);
        workListMoves.remove(mv);
        if (e.u == e.v) {
            coalescedMoves.add(mv);
            AddWorkList(e.u);
        } else if (preColored.contains(e.v) || adjSet.contains(e)
                || e.u == PhysicsReg.get("zero") || e.v == PhysicsReg.get("zero")) {
            constrainedMoves.add(mv);
            AddWorkList(e.u);
            AddWorkList(e.v);
        } else {
            boolean flag = true;
            for (Reg reg : adjacent(e.v)) flag &= OK(reg, e.u);
            LinkedHashSet<Reg> uv = new LinkedHashSet<>(adjacent(e.u));
            uv.addAll(adjacent(e.v));
            if (preColored.contains(e.u) && flag || !preColored.contains(e.u) && Conservative(uv)) {
                coalescedMoves.add(mv);
                Combine(e.u, e.v);
                AddWorkList(e.u);
            } else activeMoves.add(mv);
        }
    }
    void AddWorkList(Reg reg) {
        if (!preColored.contains(reg) && !moveRelated(reg) && degree.get(reg) < colorNum) {
            freezeWorkList.remove(reg);
            simplifyWorkList.add(reg);
        }
    }
    boolean OK(Reg t, Reg r) {
        return degree.get(t) < colorNum || preColored.contains(t) || adjSet.contains(new Edge(t, r));
    }
    boolean Conservative(LinkedHashSet<Reg> uv) {
        int k = 0;
        for (Reg reg : uv)
            if (degree.get(reg) >= colorNum)k++;
        return k < colorNum;
    }
    Reg GetAlias(Reg reg) {
        if (coalescedNodes.contains(reg)) {
            Reg regAlias = GetAlias(alias.get(reg));
            alias.put(reg, regAlias);
            return regAlias;
        } else return reg;
    }
    void Combine(Reg u, Reg v) {
        if (freezeWorkList.contains(v))
            freezeWorkList.remove(v);
        else
            spillWorkList.remove(v);
        coalescedNodes.add(v);
        alias.put(v, u);
        moveList.get(u).addAll(moveList.get(v));
        enableMoves(new LinkedHashSet<Reg>() {{ add(v); }});
        for (var t : adjacent(v)) {
            addEdge(t, u);
            DecrementDegree(t);
        }
        if (degree.get(u) >= colorNum && freezeWorkList.contains(u)) {
            freezeWorkList.remove(u);
            spillWorkList.add(u);
        }
    }
    void Freeze() {
        Reg reg = freezeWorkList.getFirst();
        freezeWorkList.remove(reg);
        simplifyWorkList.add(reg);
        FreezeMoves(reg);
    }
    void FreezeMoves(Reg reg) {
        for (var mv : nodeMoves(reg)) {
            Reg x = mv.rd, y = mv.rs1, v;
            v = GetAlias(y) == GetAlias(reg) ? GetAlias(x) : GetAlias(y);
            activeMoves.remove(mv);
            frozenMoves.add(mv);
            if (nodeMoves(v).isEmpty() && degree.get(v) < colorNum) {
                freezeWorkList.remove(v);
                simplifyWorkList.add(v);
            }
        }
    }
    void SelectSpill() {
        Reg m = null;
        for (Reg reg : spillWorkList)
            if (m == null || reg.spillWeight / degree.get(reg) < m.spillWeight / degree.get(m) && !spillTemp.contains(reg))
                m = reg;
        spillWorkList.remove(m);
        simplifyWorkList.add(m);
        FreezeMoves(m);
    }

    void AssignColors() {
        while (!selectStack.isEmpty()) {
            Reg reg = selectStack.pop();
            LinkedHashSet<Integer> okColors = new LinkedHashSet<>();
            for (int i = 5; i < 32; i++) okColors.add(i);
            for (var adj : adjList.get(reg)) {
                Reg adjAlias = GetAlias(adj);
                if (coloredNodes.contains(adjAlias) || preColored.contains(adjAlias))
                    okColors.remove(color.get(adjAlias));
            }
            if (okColors.isEmpty())
                spilledNodes.add(reg);
            else {
                coloredNodes.add(reg);
                color.put(reg, okColors.iterator().next());
            }
        }
        for (Reg reg : coalescedNodes)
            color.put(reg, color.get(GetAlias(reg)));
    }
    //下面是重写部分
    void allocateUse(VirtualReg newReg, VirtualReg reg) {
        if (reg.stackOffset < 1 << 11)
            newInsts.add(new ASMLoadInst(reg.size, newReg, RegSp, new Imm(reg.stackOffset)));
        else {
            newInsts.add(new ASMLiInst(newReg, new VirtualImm(reg.stackOffset)));
            newInsts.add(new ASMBinaryInst("add", newReg, newReg, RegSp));
            newInsts.add(new ASMLoadInst(reg.size, newReg, newReg));
        }
    }

    void allocateDef(VirtualReg newReg, VirtualReg reg) {
        if (reg.stackOffset < 1 << 11)
            newInsts.add(new ASMStoreInst(reg.size, RegSp, newReg, new Imm(reg.stackOffset)));
        else {
            VirtualReg addr = new VirtualReg(4);
            spillTemp.add(addr);
            newInsts.add(new ASMLiInst(addr, new VirtualImm(reg.stackOffset)));
            newInsts.add(new ASMBinaryInst("add", addr, addr, RegSp));
            newInsts.add(new ASMStoreInst(reg.size, addr, newReg));
        }
    }
    void RewriteProgram(ASMFunction func) {
        for (Reg reg : spilledNodes) {
            ((VirtualReg) reg).stackOffset = func.paramUsed + func.allocaUsed + func.spillUsed;
            func.spillUsed += 4;
        }
        for (var block : func.blocks) {
            newInsts = new LinkedList<>();
            for (ASMInst inst : block.insts) {
                VirtualReg same = null;
                if (inst.rs1 != null && inst.rs1.stackOffset != null) {
                    VirtualReg newReg = new VirtualReg(4);
                    spillTemp.add(newReg);
                    allocateUse(newReg, (VirtualReg) inst.rs1);
                    if (inst.rs1 == inst.rs2)
                        inst.rs2 = newReg;
                    if (inst.rs1 == inst.rd)
                        same = newReg;
                    inst.rs1 = newReg;
                }
                if (inst.rs2 != null && inst.rs2.stackOffset != null) {
                    VirtualReg newReg = new VirtualReg(4);
                    spillTemp.add(newReg);
                    allocateUse(newReg, (VirtualReg) inst.rs2);
                    if (inst.rs2 == inst.rd)
                        same = newReg;
                    inst.rs2 = newReg;
                }
                newInsts.add(inst);
                if (inst.rd != null && inst.rd.stackOffset != null) {
                    VirtualReg newReg = same == null ? new VirtualReg(4) : same;
                    spillTemp.add(newReg);
                    allocateDef(newReg, (VirtualReg) inst.rd);
                    inst.rd = newReg;
                }
            }
            block.insts = newInsts;
        }
    }
    //为染色后的图分配栈空间
    public void Stackallocator() {
        for (var curFunc : module.functions) {
            int totalStack = curFunc.paramUsed + curFunc.allocaUsed + curFunc.spillUsed;

            if (totalStack < 1 << 11)
                curFunc.blocks.get(0).insts.addFirst(new ASMUnaryInst("addi", PhysicsReg.get("sp"), PhysicsReg.get("sp"),
                        new Imm(-totalStack)));
            else {
                curFunc.blocks.get(0).insts.addFirst(new ASMBinaryInst("add", PhysicsReg.regMap.get("sp"), PhysicsReg.get("sp"),
                        PhysicsReg.get("t0")));
                curFunc.blocks.get(0).insts.addFirst(new ASMLiInst(PhysicsReg.get("t0"), new VirtualImm(-totalStack)));
            }

            if (totalStack < 1 << 11)
                curFunc.blocks.get(curFunc.blocks.size() - 1).insts.add(new ASMUnaryInst("addi", PhysicsReg.get("sp"), PhysicsReg.get("sp"),
                        new Imm(totalStack)));
            else {
                curFunc.blocks.get(curFunc.blocks.size() - 1).insts.add(new ASMLiInst(PhysicsReg.get("t0"), new VirtualImm(totalStack)));
                curFunc.blocks.get(curFunc.blocks.size() - 1).insts.add(new ASMBinaryInst("add", PhysicsReg.get("sp"), PhysicsReg.get("sp"),
                        PhysicsReg.get("t0")));
            }
            curFunc.blocks.get(curFunc.blocks.size() - 1).insts.add(new ASMRetInst());
        }
    }
}
