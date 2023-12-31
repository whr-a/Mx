package IR.inst;

import IR.entity.*;
import IR.*;

import java.util.LinkedHashSet;

public class IRStoreInst extends IRInst {
    public IREntity val;//存入的值
    public IRRegister destAddr;//存入哪个地址
    public int param_idx = -1;
    // 如果param_idx不是-1，说明是往函数参数里面store东西

    public IRStoreInst(IRbasicblock block, IREntity val, IRRegister destAddr) {
        super(block);
        this.val = val;
        this.destAddr = destAddr;
    }

    public IRStoreInst(IRbasicblock block, IREntity val, IRRegister destAddr, int param_idx) {
        super(block);
        this.val = val;
        this.destAddr = destAddr;
        this.param_idx = param_idx;
    }

    @Override
    public String toString() {
        return "store " + val.toStringWithType() + ", " + destAddr.toStringWithType();
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    public void replaceUse(IREntity old, IREntity newOne) {
        if (val == old)
            val = newOne;
        if (destAddr == old)
            destAddr = (IRRegister) newOne;
    }
    @Override
    public LinkedHashSet<IREntity> getUse() {
        LinkedHashSet<IREntity> ret = new LinkedHashSet<>();
        ret.add(val);
        ret.add(destAddr);
        return ret;
    }
}