package back;

import IR.*;

import java.util.*;

public class DomsTreeBuilder {
    HashSet<IRbasicblock> visited = new HashSet<>();
    HashMap<IRbasicblock, Integer> order = new HashMap<>();
    LinkedList<IRbasicblock> blockSeq = new LinkedList<>();
    public DomsTreeBuilder(IRprogram program){
        for(var def:program.functions){
            work(def);
        }
    }
    void getorder(IRbasicblock block){
        visited.add(block);
        for(var def : block.behind){
            if(!visited.contains(def))
                getorder(def);
        }
        order.put(block,blockSeq.size());
        blockSeq.addFirst(block);
    }
    void work(IRfunction func){
        visited.clear();
        order.clear();
        blockSeq.clear();
        getorder(func.entryBlock);
        func.entryBlock.domfather = func.entryBlock;
        blockSeq.removeFirst();
        boolean changed = true;
        while(changed){
            changed = false;
            for(var block :blockSeq){
                IRbasicblock newIdom = null;
                for(var front : block.front){
                    if(newIdom == null) newIdom = front;
                    else if (front.domfather !=null)
                        newIdom = findfather(front, newIdom);
                }
                if(newIdom != block.domfather){
                    block.domfather = newIdom;
                    changed = true;
                }
            }
        }
        for(var def : blockSeq){
            def.domfather.domChildren.add(def);
        }
        //计算支配边界
        blockSeq.addFirst(func.entryBlock);
        for (IRbasicblock block : blockSeq){
            if(block.front.size() < 2) continue;
            for(IRbasicblock front : block.front){
                IRbasicblock x = front;
                while(x != block.domfather){
                    x.domFrontier.add(block);
                    x = x.domfather;
                }
            }

        }
    }
    IRbasicblock findfather(IRbasicblock a,IRbasicblock b){
        while(a!=b){
            while (order.get(a) < order.get(b))a = a.domfather;
            while (order.get(b) < order.get(a))b = b.domfather;
        }
        return a;
    }
}
