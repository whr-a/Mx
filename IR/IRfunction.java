package IR;

import java.util.ArrayList;
import java.util.LinkedList;

import IR.IRtype.*;
import IR.entity.*;
import IR.inst.*;

public class IRfunction{
    public String name;
    public IRBaseType type;
    public LinkedList<IRbasicblock> blocklist = new LinkedList<IRbasicblock>();
    public ArrayList<IRRegister> params = new ArrayList<IRRegister>();
    public ArrayList<IRAllocaInst> allocaInsts = new ArrayList<IRAllocaInst>();
    //函数里面要先allocated的都在里面
    public IRbasicblock entryBlock, exitBlock;
    public IRRegister retAddr;
    public IRfunction(String name_, IRBaseType type_) {
        this.name = name_;
        this.type = type_;
    }
    public IRbasicblock appendBlock(IRbasicblock block) {
        blocklist.add(block);
        return block;
    }
    public void finish() {
        entryBlock = blocklist.getFirst();
        for (int i = allocaInsts.size() - 1; i >= 0; --i)
            entryBlock.insts.addFirst(allocaInsts.get(i));
        blocklist.add(exitBlock);
    }
    public String toString() {
        String ret = "define " + type.toString() + " @" + name + "(";
        IRRegister.cnt = 0;
        for (int i = 0; i < params.size(); ++i) {
            ret += params.get(i).toStringWithType();
            if (i != params.size() - 1) ret += ", ";
        }
        ret += ") {\n";
        for (IRbasicblock block : blocklist)
            ret += block.toString();
        ret += "}\n";
        return ret;
    }
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
