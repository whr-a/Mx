package AST;

import java.util.ArrayList;

import Utils.position;

public class functionDeclParamListNode extends Node{
    public ArrayList<VarDefUnitNode> args = new ArrayList<VarDefUnitNode>();

    public functionDeclParamListNode(position pos) {
        super(pos);
    }
    
}
