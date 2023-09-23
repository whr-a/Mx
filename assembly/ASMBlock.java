package assembly;

import assembly.inst.*;

import java.util.LinkedList;

public class ASMBlock {
    public String name;
    public LinkedList<ASMInst> insts = new LinkedList<ASMInst>();
    public ASMInst branch_terminal;
    public ASMInst terminal;
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
//        for (var inst : phiConvert) {
//            ret += "  " + inst + "\n";
//            System.err.println("Fxx");
//        }
        for (ASMInst inst : insts)
            ret += "  " + inst + "\n";
        for (var mv : phiConvert) {
            ret += "  " + mv + "\n";
        }
        if (branch_terminal != null) {
            ret += "  " + branch_terminal + "\n";
        }
        if (terminal != null) {
            ret += "  " + terminal + "\n";
        }
        return ret;
    }
}