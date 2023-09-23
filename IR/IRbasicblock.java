package IR;

import java.util.LinkedList;

import IR.inst.*;

public class IRbasicblock {
    public String name;
    public LinkedList<IRInst> insts = new LinkedList<IRInst>();
    public IRTerminalInst terminalInst = null;
    public IRfunction parentFunction = null;
    public int loopDepth = 0;
    public static int Cnt = 0;
    public boolean isFinished = false;
    public LinkedList<IRbasicblock> front = new LinkedList<>();
    public LinkedList<IRbasicblock> behind = new LinkedList<>();
    public IRbasicblock domfather = null;
    public LinkedList<IRbasicblock> domChildren = new LinkedList<>();
    public LinkedList<IRbasicblock> domFrontier = new LinkedList<>();
    public LinkedList<IRPhiInst> phiInsts = new LinkedList<>();
    public IRbasicblock(String lable_){
        this.name = lable_;
    }
    public IRbasicblock(IRfunction function, String name, int loopDepth) {
        this.parentFunction = function;
        this.name = name + String.valueOf(Cnt++);
        this.loopDepth = loopDepth;
    }
    public IRbasicblock(IRfunction function, String name, IRbasicblock toBlock, int loopDepth) {
        this(function, name, loopDepth);
        this.terminalInst = new IRJumpInst(this, toBlock);
      }
    public void push_back(IRInst stmt){
        insts.add(stmt);
    }
    public void addInst(IRInst inst) {
        if(inst instanceof IRPhiInst phiInst){
            for(IRPhiInst def : phiInsts)
                if(phiInst.src == def.src)return;//不允许有来源相同的phi
            phiInsts.add((IRPhiInst)inst);
            return;
        }
        if (isFinished) return;
        if (inst instanceof IRAllocaInst)
            parentFunction.allocaInsts.add((IRAllocaInst) inst);
        else if (inst instanceof IRTerminalInst)
            terminalInst = (IRTerminalInst) inst;
        else
            insts.add(inst);
    }
    public String toString() {
        String ret = name + ":\n";
        for (IRInst inst : insts)
            ret += "  " + inst + "\n";
        if (terminalInst != null)
            ret += "  " + terminalInst + "\n";
        return ret;
    }
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
