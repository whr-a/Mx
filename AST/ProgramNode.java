package AST;

import java.util.ArrayList;

import Utils.position;

public class ProgramNode extends Node{
    public ArrayList<Node> deflist = new ArrayList<Node>();
    public ProgramNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
