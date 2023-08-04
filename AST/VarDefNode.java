package AST;

import java.util.ArrayList;

import AST.stmt.StmtNode;
import Utils.position;

public class VarDefNode extends StmtNode{
    
    public ArrayList<VarDefUnitNode> units = new ArrayList<VarDefUnitNode>();
    
    public VarDefNode(position pos){
        super(pos);
    }
}
