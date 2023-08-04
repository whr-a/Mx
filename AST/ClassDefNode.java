package AST;

import java.util.ArrayList;

import Utils.position;

public class ClassDefNode extends Node{
    public String name;
    public ArrayList<Node> components=new ArrayList<Node>();
    public ClassDefNode(position pos,String name) {
        super(pos);
        this.name = name;
    }
    
}
