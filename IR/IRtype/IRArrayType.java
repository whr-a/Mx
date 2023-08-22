package IR.IRtype;

import IR.entity.IREntity;
import IR.entity.IRNullConst;

public class IRArrayType extends IRBaseType{
    public IRBaseType baseType;
    public int cnt;
    public IRArrayType(IRBaseType baseType, int cnt) {
        super("[" + String.valueOf(cnt) + " x " + baseType.name + "]", baseType.size * cnt);
        this.baseType = baseType;
        this.cnt = cnt;
    }
    @Override
    public IRBaseType Type() {
        return this;
    }
    @Override
    public IREntity defaultValue() {
        return new IRNullConst(this);
    }
    @Override
    public String toString() {
        return "[" + String.valueOf(cnt) + " x " + baseType.toString() + "]";
    }
}
