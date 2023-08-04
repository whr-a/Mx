package AST.expr;

import Utils.position;
//此文件是函数调用表达式
public class FunctionExp extends ExprNode{
    public ExprNode functionName;
    public ExprNodeList args;
    public FunctionExp(position pos,ExprNode funcName) {
        super(pos);
        this.functionName = funcName;
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
    
}
