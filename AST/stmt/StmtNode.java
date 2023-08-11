package AST.stmt;

import AST.Node;
import Utils.position;

public abstract class StmtNode extends Node {
    public StmtNode(position pos) {
        super(pos);
    }
}