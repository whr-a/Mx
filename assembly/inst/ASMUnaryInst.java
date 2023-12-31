package assembly.inst;

import assembly.operand.*;
//包含 seqz, snez, slli, xori, addi
public class ASMUnaryInst extends ASMInst {
    String op;
    

    public ASMUnaryInst(String op, Reg rd, Reg rs1) {
        this.op = op;
        this.rd = rd;
        this.rs1 = rs1;
    }

    public ASMUnaryInst(String op, Reg rd, Reg rs1, Imm imm) {
        this.op = op;
        this.rd = rd;
        this.rs1 = rs1;
        this.imm = imm;
    }

    @Override
    public String toString() {
        if (imm == null)
        return op + " " + rd + ", " + rs1;
        else
        return op + " " + rd + ", " + rs1 + ", " + imm;
    }
}