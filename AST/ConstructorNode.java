package AST;

import java.util.ArrayList;

import AST.stmt.StmtNode;
import Utils.position;

public class ConstructorNode extends Node{
    public String name;
    public ArrayList<StmtNode> stmts = new ArrayList<StmtNode>();
    public ConstructorNode(position pos) {
        super(pos);
        //TODO Auto-generated constructor stub
    }
}
