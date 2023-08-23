package IR.entity;

import IR.IRtype.IRArrayType;
import IR.IRtype.IRIntType;
import IR.IRtype.IRPtrType;
import Utils.BuiltinElements;

public class IRStringConst extends IRConst implements BuiltinElements{
    public String val;
    public int id;
    public static int cnt = 0;
    public IRStringConst(String val_) {
        super(new IRPtrType(new IRArrayType(irCharType, val_.length() + 1)));
        this.val = val_;
        this.id = cnt++;
    }
    @Override
    public String toString() {
        return "@str." + String.valueOf(id);
    }
    public String printStr() {
        String ret = "";
        for (int i = 0; i < val.length(); ++i) {
            char c = val.charAt(i);
            switch (c) {
                case '\n': ret += "\\0A"; break;
                case '\"': ret += "\\22"; break;
                case '\\': ret += "\\\\"; break;
                default: ret += c;
            }
        }
        return ret + "\\00";
    }
    @Override
    public String toStringWithType() {
        return "[" + String.valueOf(val.length() + 1) + " x i8]* " + toString();
    }
    @Override
    public boolean isZero() {
        return false;
    }
}
