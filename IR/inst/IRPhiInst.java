package IR.inst;
import IR.*;
import IR.entity.*;

import java.util.*;

public class IRPhiInst extends IRInst{
    public IRRegister dest, src;
    public ArrayList<IREntity> values = new ArrayList<>();
    public ArrayList<IRbasicblock> blocks = new ArrayList<>();
    public IRPhiInst(IRbasicblock block, IRRegister src_, IRRegister dest_) {
        super(block);
        this.src=src_;
        this.dest=dest_;
    }
    public void add(IREntity value, IRbasicblock block){
        blocks.add(block);
        values.add(value == null ? dest.type.defaultValue() : value);
    }
    @Override
    public String toString() {
        String ret = dest + " = phi " + dest.type + " ";
        for (int i=0;i<values.size();i++) {
            ret += "[ " + values.get(i) + ", %" + blocks.get(i).name + " ]";
            if (i != values.size() - 1) ret += ", ";
        }
        return ret;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    public void replaceUse(IREntity old, IREntity newOne) {
        for (int i = 0; i < values.size(); ++i)
            values.set(i, values.get(i) == old ? newOne : values.get(i));
    }
    @Override
    public LinkedHashSet<IREntity> getUse() {
        LinkedHashSet<IREntity> ret = new LinkedHashSet<>();
        for (IREntity value : values) ret.add(value);
        return ret;
    }
}
