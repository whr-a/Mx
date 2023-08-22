package AST.expr;

import AST.FuncDefNode;
import AST.Node;
import Utils.*;
import IR.entity.*;
import IR.IRtype.*;
public abstract class ExprNode extends Node{
    public String str;
    public Type type;
    public FuncDefNode funcDef = null;
    public IREntity value = null;
    public IRRegister storePtr = null;//左值的存储位置
    //如果有storePtr而没有value，说明这个左值还没有被load出来
    //如果有value而没有storePtr，说明这是个右值，而且还没有被store到内存中
    public ExprNode(position pos) {
        super(pos);
    }
    public abstract boolean isLeftValue();
    public IRBaseType getIRType() {
        return value.type;
    }
}
