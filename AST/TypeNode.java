package AST;

import Utils.*;

public class TypeNode extends Node{
    public Type type;
    public TypeNode(position pos) {
        super(pos);
    }
    public TypeNode(position pos,Type type) {
        super(pos);
        this.type = type;
    }
    
}
