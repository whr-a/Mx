package IR.entity;

import IR.IRtype.IRBaseType;

public abstract class IRConst extends IREntity{

    public IRConst(String name_, IRBaseType type_) {
        super(name_, type_);
    }
    public IRConst(IRBaseType type_) {
        super(type_);
    }
}
