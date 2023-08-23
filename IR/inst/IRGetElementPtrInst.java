package IR.inst;

import IR.entity.*;
import IR.IRtype.*;
import IR.*;

import java.util.ArrayList;

public class IRGetElementPtrInst extends IRInst {
    public IRRegister res;
    public IREntity ptr;
    public IRBaseType pToType;
    public ArrayList<IREntity> indexList = new ArrayList<IREntity>();

    public IRGetElementPtrInst(IRbasicblock block, IREntity ptr, IRRegister res, IREntity... indexList) {
        super(block);
        this.ptr = ptr;
        this.pToType = ((IRPtrType) ptr.type).pointToType();
        this.res = res;
        for (IREntity index : indexList)
        this.indexList.add(index);
    }

    @Override
    public String toString() {
        String ret = res + " = getelementptr " + pToType + ", " + ptr.toStringWithType();
        for (IREntity index : indexList)
        ret += ", " + index.toStringWithType();
        return ret;
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}