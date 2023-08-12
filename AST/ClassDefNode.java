package AST;

import java.util.ArrayList;
import java.util.HashMap;

import Utils.*;

public class ClassDefNode extends Node{
    public String name;
    public ArrayList<VarDefNode> varDefList = new ArrayList<VarDefNode>();
    public ArrayList<FuncDefNode> funcDefList = new ArrayList<FuncDefNode>();
    public HashMap<String, VarDefUnitNode> varMember = new HashMap<String, VarDefUnitNode>();
    public HashMap<String, FuncDefNode> funcMember = new HashMap<String, FuncDefNode>();
    public ConstructorNode builder;
    public ClassDefNode(position pos,String name) {
        super(pos);
        this.name = name;
    }
    public FuncDefNode getFuncDef(String name) {
        return funcMember.get(name);
    }
    public Type getVarType(String name) {
        VarDefUnitNode unit = varMember.get(name);
        if (unit == null) return null;
        else return unit.type.type;

    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
