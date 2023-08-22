package IR.IRtype;

import IR.entity.IREntity;
import IR.entity.IRNullConst;

public class IRPtrType extends IRBaseType{
    public IRBaseType baseType;
    public int dim;
    public IRPtrType(IRBaseType pointee_, int dim_) {
        super(pointee_.name, 4);
        baseType = pointee_;
        dim = dim_;
    }
    public IRPtrType(IRBaseType pointee_) {
        super(pointee_.name, 4);
        baseType = pointee_;
        dim = 1;
    }
    public IRBaseType 
    pointToType() {
        return dim == 1 ? baseType : new IRPtrType(baseType, dim - 1);
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
        return "ptr";
    }
}
