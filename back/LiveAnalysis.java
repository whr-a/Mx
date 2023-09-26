package back;

import assembly.*;
import assembly.inst.*;
import assembly.operand.*;
import java.util.*;

public class LiveAnalysis {
    ASMFunction func;
    HashSet<ASMBlock> initiallist = new HashSet<>();
    LinkedList<ASMBlock> queue = new LinkedList<>();

    public LiveAnalysis(ASMFunction func) {
        this.func = func;
        for (ASMBlock block : func.blocks) {
            block.liveIn.clear();
            block.liveOut.clear();
        }
        //计算每一个块的use和def
        //use[𝑝] ∪ (use[𝑛] − def [𝑝]) 视为 𝑝𝑛 的等效 use，把 def [𝑛] ∪ def [𝑝] 视为 𝑝𝑛 的等效 def ——截自编译器指导手册
        for (ASMBlock block : func.blocks) {
            block.use.clear();
            block.def.clear();
            for (ASMInst inst : block.insts) {
                for (var reg : inst.getUse())
                    if (!block.def.contains(reg))
                        block.use.add(reg);
                block.def.addAll(inst.getDef());
            }
        }
    }
    
    public void work() {
        queue.clear();
        initiallist.clear();
        //从最后一个块开始
//        var entryBlock = func.blocks.get(0);
        var exitBlock = func.blocks.get(func.blocks.size() - 1);
        queue.add(exitBlock);
        initiallist.add(exitBlock);
        while (!queue.isEmpty()) {
            ASMBlock block = queue.removeFirst();
            initiallist.remove(block);
            HashSet<Reg> newLiveOut = new HashSet<>();

            for (var succ : block.behind) newLiveOut.addAll(succ.liveIn);
            HashSet<Reg> newLiveIn = new HashSet<>(block.use);
            newLiveIn.addAll(newLiveOut);
            newLiveIn.removeAll(block.def);

            if (!newLiveIn.equals(block.liveIn) || !newLiveOut.equals(block.liveOut)) {
                block.liveIn = newLiveIn;
                block.liveOut = newLiveOut;
                for (var pred : block.front)
                    if (!initiallist.contains(pred)) {
                        queue.add(pred);
                        initiallist.add(pred);
                    }
            }
        }
    }
}
