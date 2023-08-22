package IR.entity;
import Utils.BuiltinElements;
public class IRBoolConst extends IRConst implements BuiltinElements{
    public boolean value;
    public IRBoolConst(boolean value) {
        super(irBoolType);
        this.value = value;
    }
    @Override
    public String toString() {
        return value ? "1" : "0";
    }

    @Override
    public String toStringWithType() {
        return "i1 " + toString();
    }
}
