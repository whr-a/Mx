package IR.IRtype;

import java.util.ArrayList;
import java.util.HashMap;

import IR.entity.IREntity;
import IR.entity.IRNullConst;

public class IRClassType extends IRBaseType{
    public ArrayList<IRBaseType> membertype = new ArrayList<IRBaseType>();
    public HashMap<String, Integer> memberindex = new HashMap<>();//成员是第几个
    public boolean hasBuild = false;
    public IRClassType(String name_, int size_) {
        super(name_, size_);
    }
    public IRBaseType gettype(String name) {
        if(!memberindex.containsKey(name))return null;
        else return membertype.get(memberindex.get(name));
    }
    public void addmember(String name_, IRBaseType type_) {
        membertype.add(type_);
        memberindex.put(name_, membertype.size()-1);
    }
    public boolean hasMember(String name) {
        return memberindex.containsKey(name);
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
        return "%struct." + name;
    }
}
