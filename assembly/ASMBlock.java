package assembly;

import assembly.inst.*;
import java.util.LinkedList;

public class ASMBlock {
    public String name; 
    public LinkedList<ASMInst> insts = new LinkedList<ASMInst>();
    public LinkedList<ASMInst> phiConvert = new LinkedList<ASMInst>();

    public ASMBlock(String name) {
        this.name = name;
    }

    public void addInst(ASMInst inst) {
        insts.add(inst);
    }

    public String toString() {
        String ret = "";
        if (name != null) ret += name + ":\n";//name为null的时候不输出名字
        for (ASMInst inst : insts)
            ret += "  " + inst + "\n";
        return ret;
    }
}