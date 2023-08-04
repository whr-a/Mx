package AST;

import Utils.position;

import java.util.ArrayList;

import AST.expr.*;
public class FuncCallArgsNode extends Node{
    public ArrayList<ExprNode> exprs=new ArrayList<ExprNode>();
    public FuncCallArgsNode(position pos) {
        super(pos);
    }    
}
