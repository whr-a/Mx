package IR.IRtype;

import IR.entity.IREntity;
import Utils.BuiltinElements;
public class IRIntType extends IRBaseType implements BuiltinElements{
    public int length;
    public IRIntType(int length_){
        super("i"+String.valueOf(length_),length_/8);
        length = length_;
    }
    @Override
    public IRBaseType Type() {
        return this;
    }
    @Override
    public IREntity defaultValue() {
        return irIntConst0;
    }
    @Override
    public String toString() {
        return "i" + String.valueOf(length);
    }
}
