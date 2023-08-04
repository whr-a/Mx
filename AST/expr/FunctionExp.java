package AST.expr;

import AST.FuncCallArgsNode;
import Utils.position;
//此文件是函数调用表达式
public class FunctionExp extends ExprNode{
    public String functionName;
    public FuncCallArgsNode args;
    public FunctionExp(position pos,String funcName) {
        super(pos);
        this.functionName = funcName;
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
    
}
