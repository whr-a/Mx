package AST;

import AST.expr.*;
import Utils.*;

public class VarDefUnitNode extends Node{
    public TypeNode type;
    public String name;
    public ExprNode inival;
    public VarDefUnitNode(position pos,TypeNode type,String name){
        super(pos);
        this.type = type;
        this.name = name;
    }
    public VarDefUnitNode(position pos,TypeNode type,String name,ExprNode inival){
        this(pos,type,name);
        this.inival = inival;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
