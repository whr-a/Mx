package assembly;

import assembly.inst.*;
import assembly.operand.*;
import java.util.*;

public class ASMBlock {
    public String name;

    public LinkedList<ASMInst> insts = new LinkedList<ASMInst>();
    public HashSet<Reg> liveIn = new HashSet<Reg>();
    public HashSet<Reg> liveOut = new HashSet<Reg>();
    public HashSet<Reg> use = new HashSet<Reg>(), def = new HashSet<Reg>();
    public LinkedList<ASMBlock> behind = new LinkedList<ASMBlock>();
    public LinkedList<ASMBlock> front = new LinkedList<ASMBlock>();

    public LinkedList<ASMInst> jumpOrBr = new LinkedList<ASMInst>();
//    public ASMInst branch_terminal;
//    public ASMInst terminal;
    public LinkedList<ASMInst> phiConvert = new LinkedList<ASMInst>();

    public ASMBlock(String name) {
        this.name = name;
    }

    public void addInst(ASMInst inst) {
        if (inst instanceof ASMJumpInst || inst instanceof ASMBeqzInst || inst instanceof ASMCmpBrInst)
            jumpOrBr.add(inst);
        else
            insts.add(inst);
    }
    public int loopDepth = 0;

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
//        if (branch_terminal != null) {
//            ret += "  " + branch_terminal + "\n";
//        }
//        if (terminal != null) {
//            ret += "  " + terminal + "\n";
//        }
        return ret;
    }
}