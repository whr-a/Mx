package IR.entity;

import IR.IRtype.*;
import assembly.operand.Reg;

public abstract class IREntity {
    public String name;//这个实体的名称
    public IRBaseType type;//这个实体的类型
    public Reg asmReg;
    public IREntity(String name,IRBaseType type_){
        this.type = type_;
        this.name = name;
    }
    public IREntity(IRBaseType type_){
        this.type = type_;
    }
    public abstract String toString();

    public abstract String toStringWithType();
}
