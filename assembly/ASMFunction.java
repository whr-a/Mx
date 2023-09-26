package assembly;

import assembly.operand.*;
import java.util.ArrayList;

public class ASMFunction {
    public String name;
    public ArrayList<ASMBlock> blocks = new ArrayList<ASMBlock>();
    public ArrayList<Reg> params = new ArrayList<Reg>();
    public int virtualRegCnt = 0;//虚拟寄存器的使用个数
    public int allocaUsed = 4;//返回值要预留4位
    public int spillUsed = 0;
    public int paramUsed = 0;//内部所有call指令最大所需的栈帧空间
    public int totalStack = 0;//需要的总空间

    public ASMFunction(String name) {
        this.name = name;
    }

    public void addBlock(ASMBlock block) {
        blocks.add(block);
    }

    public String toString() {
        String ret = "  .text\n" + "  .globl " + name + "\n";
        ret += name + ":\n";
        for (ASMBlock block : blocks)ret += block.toString();
        return ret;
    }  
}