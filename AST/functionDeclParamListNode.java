package AST;

import java.util.ArrayList;

import javax.swing.text.Position;

import Utils.*;

public class functionDeclParamListNode extends Node{
    public ArrayList<VarDefUnitNode> args = new ArrayList<VarDefUnitNode>();
    public functionDeclParamListNode(position pos) {
        super(pos);
    }
    public functionDeclParamListNode(position pos, Type type, int cnt) {
        super(pos);
        for (int i = 0; i < cnt; ++i)
            args.add(new VarDefUnitNode(pos, new TypeNode(pos, type.type, type.dim), "a" + i));
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
