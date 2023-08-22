package AST;

import Utils.*;
import IR.IRtype.*;
public class TypeNode extends Node implements BuiltinElements{
    public Type type;
    public IRBaseType irType;
    public TypeNode(position pos) {
        super(pos);
    }
//    public TypeNode(position pos,Type type) {
//        super(pos);
//        this.type = type;
//    }
    public TypeNode(position pos, String name, int dim) {
        super(pos);
        if (dim == 0) {
            switch (name) {
                case "int" -> this.type = IntType;
                case "bool" -> this.type = BoolType;
                case "string" -> this.type = StringType;
                case "void" -> this.type = VoidType;
                default -> this.type = new Type(name);
            }
        } else {
            this.type = new Type(name, dim);
        }
    }
    public TypeNode(position pos, String name) {
        super(pos);
        switch (name) {
            case "int" -> this.type = IntType;
            case "bool" -> this.type = BoolType;
            case "string" -> this.type = StringType;
            case "void" -> this.type = VoidType;
            default -> this.type = new Type(name);
        }
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
