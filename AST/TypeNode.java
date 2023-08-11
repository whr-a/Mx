package AST;

import Utils.*;

public class TypeNode extends Node implements BuiltinElements{
    public Type type;
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
                case "int":
                this.type = IntType; break;
                case "bool":
                this.type = BoolType; break;
                case "string":
                this.type = StringType; break;
                case "void":
                this.type = VoidType; break;
                default:
                this.type = new Type(name);
            }
        } else {
            this.type = new Type(name, dim);
        }
    }
    public TypeNode(position pos, String name) {
        super(pos);
        switch (name) {
            case "int":
                this.type = IntType; break;
            case "bool":
                this.type = BoolType; break;
            case "string":
                this.type = StringType; break;
            case "void":
                this.type = VoidType; break;
            default:
                this.type = new Type(name);
        }
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
