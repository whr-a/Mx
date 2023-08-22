package IR.entity;
import Utils.BuiltinElements;
public class IRIntConst extends IRConst implements BuiltinElements{
    public int val;
    public IRIntConst(int val){
        super(irIntType);
        this.val=val;
    }
    @Override
    public String toString() {
        return String.valueOf(val);
    }

    @Override
    public String toStringWithType() {
        return "i32 " + toString();
    }
}
