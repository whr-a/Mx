package IR.IRtype;

import IR.entity.IREntity;

public class IRVoidType extends IRBaseType{

    public IRVoidType(String name_) {
        super("void", 0);
    }
    @Override
    public IRBaseType Type() {
        return this;
    }
    @Override
    public IREntity defaultValue() {
        return null;
    }
    @Override
    public String toString() {
        return "void";
    }
}
