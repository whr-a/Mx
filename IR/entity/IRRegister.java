package IR.entity;

import IR.IRtype.IRBaseType;

public class IRRegister extends IREntity{
    public int id;
    public static int cnt = 0;
    public IRRegister(String name,IRBaseType type_) {
        super(name,type_);
        this.id = cnt++;
    }
    @Override
    public String toString() {
        if (id == -1 && (name == null || !name.equals("retval")))id = cnt++;
        return "%" + (name != null && name.equals("retval") ? name : "." + String.valueOf(id));
    }

    @Override
    public String toStringWithType() {
        return type + " " + toString();
    }
}
