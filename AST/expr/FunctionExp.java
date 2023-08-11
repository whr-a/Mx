package AST.expr;

import AST.ASTVisitor;
import AST.FuncCallArgsNode;
import Utils.position;
//此文件是函数调用表达式
public class FunctionExp extends ExprNode{
    public ExprNode functionName;
    public FuncCallArgsNode args;
    public FunctionExp(position pos,ExprNode funcName) {
        super(pos);
        this.functionName = funcName;
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
