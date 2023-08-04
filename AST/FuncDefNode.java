package AST;

import Utils.*;

import java.util.ArrayList;

import AST.stmt.*;
public class FuncDefNode extends Node{
    public TypeNode returnType;
    public String funcName;
    public functionDeclParamListNode args;
    public ArrayList<StmtNode> stmts = new ArrayList<StmtNode>();
    public FuncDefNode(position pos) {
        super(pos);
    }
    
}
