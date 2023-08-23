package IR.entity;
import Utils.BuiltinElements;
public class IRVoidConst extends IRConst implements BuiltinElements{
    public IRVoidConst() {
        super(irVoidType);
    }
    @Override
    public String toStringWithType() {
        return toString();
    }
    @Override
    public String toString() {
        return "void";
    }
    @Override
    public boolean isZero() {
        return false;
    }
    
}
