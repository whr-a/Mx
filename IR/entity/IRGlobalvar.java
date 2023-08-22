package IR.entity;

import IR.IRtype.IRBaseType;
import IR.IRtype.IRPtrType;

public class IRGlobalvar extends IRRegister{
    public IREntity initVal;
    public boolean isCallInit = false;//需不需要调用初始化函数
    public IRGlobalvar(String name, IRBaseType type_) {
        super(name, new IRPtrType(type_,1));
    }
    @Override
    public String toString() {
        return "@" + name;
    }

    @Override
    public String toStringWithType() {
        return type + " " + toString();
    }
}
