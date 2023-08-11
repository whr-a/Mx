package AST;

import Utils.position;

public class literal extends Node{
    
    public literal(position pos) {
        super(pos);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void accept(ASTVisitor visitor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}
