package back;
import IR.*;
import IR.inst.*;
import IR.entity.*;

import java.util.LinkedList;

public class CFGBuilder {
    public CFGBuilder(IRprogram program) {
        for (var def : program.functions) {
            work(def);
        }
    }
    public void work(IRfunction func){
        for(var def : func.blocklist){
            if (def.terminalInst instanceof IRBranchInst) {
                IRBranchInst branchInst = (IRBranchInst) def.terminalInst;
                def.behind.add(branchInst.thenBlock);
                def.behind.add(branchInst.elseBlock);
                branchInst.thenBlock.front.add(def);
                branchInst.elseBlock.front.add(def);
            }
            else if (def.terminalInst instanceof IRJumpInst) {
                IRJumpInst jumpInst = (IRJumpInst) def.terminalInst;
                def.behind.add(jumpInst.toBlock);
                jumpInst.toBlock.front.add(def);
            }
        }
        LinkedList<IRbasicblock> newBlocks = new LinkedList<>();
        for (var block : func.blocklist)//对于这个函数的所有块
            if (!block.front.isEmpty() || block == func.entryBlock)//前一个不是空或者是函数进入的块
                newBlocks.add(block);//当前块加入newBlocks
            else//前一个是空的并且不是entryBlock
                for (var succ : block.behind)
                    succ.front.remove(block);
        func.blocklist = newBlocks;
    }
}
