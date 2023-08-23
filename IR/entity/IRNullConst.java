package IR.entity;
import IR.IRtype.*;
import Utils.BuiltinElements;
public class IRNullConst extends IRConst implements BuiltinElements{
    public IRNullConst() {
        super(irNullType);
    }
    public IRNullConst(IRBaseType type) {
        super(type);
    }
    @Override
    public String toString() {
        return "null";
    }

    @Override
    public String toStringWithType() {
        return type == irNullType ? toString()  : type + " " + toString();
    }
    @Override
    public boolean isZero() {
        return true;
    }
    
}
