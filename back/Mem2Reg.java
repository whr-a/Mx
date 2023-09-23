package back;

import IR.*;
import IR.IRtype.IRPtrType;
import IR.entity.*;
import IR.inst.*;
import java.util.*;

public class Mem2Reg {
    IRprogram program;
    public Mem2Reg(IRprogram program){
        this.program = program;
    }
    IRfunction nowfunc;
    LinkedHashSet<IRRegister> promoteAllocas = new LinkedHashSet<>();
    HashMap<IRRegister, HashSet<IRbasicblock>> allocaDefs = new HashMap<>();
    HashMap<IRRegister, IREntity> reachingDef = new HashMap<>();
    public void work(){
        new DomsTreeBuilder(program);
        for(var def:program.functions){
            funcwork(def);
        }
    }
    boolean isAllocaPromoteable(IRAllocaInst inst) {
        if (inst.param_idx >= 8) return false;
        IRRegister reg = inst.allocaReg;
        for (var block : nowfunc.blocklist)
            for (var user : block.insts) {
                if (!(user instanceof IRLoadInst) && !(user instanceof IRStoreInst) && user.getUse().contains(reg)) return false;
                if (user instanceof IRStoreInst && ((IRStoreInst)user).destAddr == reg) allocaDefs.get(reg).add(block);
            }
        return true;
    }
    void promoteCollect() {
        promoteAllocas.clear();
        for (var inst : nowfunc.entryBlock.insts) {
            if (!(inst instanceof IRAllocaInst)) break;
            IRRegister reg = ((IRAllocaInst)inst).allocaReg;
            allocaDefs.put(reg, new HashSet<>());
            if (isAllocaPromoteable((IRAllocaInst) inst)) promoteAllocas.add(reg);
        }
    }
    void doMem2Reg(IRRegister reg){
        HashSet<IRbasicblock> Phi = new HashSet<>();
        HashSet<IRbasicblock> initiallist = new HashSet<>(allocaDefs.get(reg));
        LinkedList<IRbasicblock> queue = new LinkedList<>(initiallist);
        while(!queue.isEmpty()){
            IRbasicblock block = queue.removeFirst();
            initiallist.remove(block);
            for(IRbasicblock def : block.domFrontier){
                if(!Phi.contains(def)){
                    def.addInst(new IRPhiInst(def,reg,new IRRegister("",((IRPtrType)reg.type).pointToType())));
                    Phi.add(def);
                    if(!initiallist.contains(def)){
                        queue.add(def);
                        initiallist.add(def);
                    }
                }
            }
        }
    }
    void varRename(IRbasicblock block){
        var olddef = new HashMap<>(reachingDef);
        LinkedList<IRInst> newinsts = new LinkedList<>();
        for(var inst : block.phiInsts){
            reachingDef.put(inst.src,inst.dest);
        }
        for(int i=0;i<block.insts.size();i++){
            var inst = block.insts.get(i);
            if(inst instanceof IRAllocaInst && promoteAllocas.contains(((IRAllocaInst)inst).allocaReg))continue;
            if(inst instanceof IRLoadInst x && promoteAllocas.contains(x.srcAddr)){
                for(int j=i+1;j<block.insts.size();j++){
                    block.insts.get(j).replaceUse(x.destReg,reachingDef.get(x.srcAddr));
                }
                if(block.terminalInst!=null)
                    block.terminalInst.replaceUse(x.destReg,reachingDef.get(x.srcAddr));
            }
            else if(inst instanceof IRStoreInst store && promoteAllocas.contains(store.destAddr)){
                reachingDef.put(store.destAddr, store.val);
            }
            else newinsts.add(inst);
        }
        block.insts = newinsts;
        for(var def:block.behind){
            for(var phiinst:def.phiInsts){
                phiinst.add(reachingDef.get(phiinst.src),block);
            }
        }
        for(var def:block.domChildren)varRename(def);
        reachingDef = olddef;
    }
    void toPhi(IRbasicblock block){
        for(var def:block.phiInsts){
            IREntity value = def.values.get(0);
            boolean flag = true;
            for(int j=1;j<def.values.size();j++){
                if(def.values.get(j)!=value){
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(var inst:block.insts)inst.replaceUse(def.dest,value);
                def.Deleted = true;
            }
        }
        for(int i=block.phiInsts.size()-1;i>=0;i--){
            IRPhiInst inst = block.phiInsts.get(i);
            if(!inst.Deleted)block.insts.addFirst(inst);
        }
        for(var def:block.domChildren)toPhi(def);
    }
    void funcwork(IRfunction func){
        nowfunc = func;
        promoteCollect();
        for(var def:promoteAllocas)doMem2Reg(def);
        reachingDef.clear();;
        varRename(func.entryBlock);
        toPhi(func.entryBlock);
    }

}
