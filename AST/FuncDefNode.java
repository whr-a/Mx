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
    public FuncDefNode(position pos, Type type, String name, Type ArgsType, int cnt) {
        super(pos);
        this.funcName = name;
        this.returnType = new TypeNode(pos, type.type, type.dim);
        if (ArgsType != null && cnt > 0)this.args = new functionDeclParamListNode(pos, ArgsType, cnt);
    }
    public FuncDefNode(position pos, Type type, String name, String className, Type ArgsType, int cnt) {
        this(pos,type, name, ArgsType, cnt);
        this.classname = className;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
