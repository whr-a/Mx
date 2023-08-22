package IR.IRtype;

import IR.entity.IREntity;

public abstract class IRBaseType {
    public String name;
    public int size;
    public IRBaseType(String name_, int size_) {
        this.name = name_;
        this.size = size_;
    }
    public IRBaseType(String name_) {
        this.name = name_;
    }
    public abstract IRBaseType Type();
    public abstract IREntity defaultValue();
    public abstract String toString();
}
