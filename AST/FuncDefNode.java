package AST;

import Utils.*;

import java.util.ArrayList;

import AST.stmt.*;
public class FuncDefNode extends Node{
    public TypeNode returnType;//返回类型
    public String funcName;//函数名称
    public String classname = null;//这个函数是哪个类的内部函数
    public functionDeclParamListNode args = null;//函数参数定义
    public ArrayList<StmtNode> stmts = new ArrayList<StmtNode>();//函数内部内容
    public FuncDefNode(position pos) {
        super(pos);
    }
    public FuncDefNode(position pos, Type type, String name, Type paramType, int cnt) {
        super(pos);
        this.returnType = new TypeNode(pos, type.type, type.dim);
        this.funcName = name;
        if (paramType != null && cnt > 0)this.args = new functionDeclParamListNode(pos, paramType, cnt);
    }
    public FuncDefNode(position pos, Type type, String name, String className, Type paramType, int cnt) {
        super(pos);
        this.returnType = new TypeNode(pos, type.type, type.dim);
        this.funcName = name;
        this.classname = className;
        if (paramType != null && cnt > 0)this.args = new functionDeclParamListNode(pos, paramType, cnt);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
