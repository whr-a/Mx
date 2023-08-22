package IR.inst;

import IR.*;
import IR.entity.*;
import IR.IRtype.*;

import java.util.ArrayList;

public class IRCallInst extends IRInst {
    public IRBaseType returnType;
    public ArrayList<IREntity> args = new ArrayList<IREntity>();
    public IRRegister callReg;
    public String funcName;

    public IRCallInst(IRbasicblock block, IRBaseType returnType, String funcName) {
        super(block);
        this.returnType = returnType;
        this.funcName = funcName;
    }
    public IRCallInst(IRbasicblock block, IRRegister callReg, IRBaseType returnType, String funcName, IREntity... args) {
        super(block);
        this.returnType = returnType;
        this.callReg = callReg;
        this.funcName = funcName;
        for (IREntity arg : args)this.args.add(arg);
    }

    @Override
    public String toString() {
        String ret = (callReg != null ? callReg + " = call " : "call ") + returnType + " @" + funcName + "(";
        for (int i = 0; i < args.size(); ++i) {
            ret += args.get(i).toStringWithType();
            if (i != args.size() - 1) ret += ", ";
        }
        ret += ")";
        return ret;
    }
}