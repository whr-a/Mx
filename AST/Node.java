package AST;
import Utils.*;
public abstract class Node {
    public position pos;
    public Node(position pos){
        this.pos = pos;
    }
    public abstract void accept(ASTVisitor visitor);
}
