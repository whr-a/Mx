package assembly.inst;
import assembly.*;
import assembly.operand.*;
public class ASMCmpBrInst extends ASMInst{
    String op;
    ASMBlock toBlock;

    public ASMCmpBrInst(String op, Reg rs1, Reg rs2, ASMBlock toBlock) {
        this.op = op;
        this.toBlock = toBlock;
        this.rs1 = rs1;
        this.rs2 = rs2;
    }

    @Override
    public String toString() {
        return op + " " + rs1 + ", " + rs2 + ", " + toBlock.name;
    }
}
