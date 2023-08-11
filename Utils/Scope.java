package Utils;

import java.util.HashMap;
import AST.*;
import AST.stmt.*;

public class Scope {
    public HashMap<String, Type> varMember = new HashMap<>();
    public Scope parentScope = null;
    public Type returnType = null;
    public ClassDefNode inWhichClass = null;
    public LoopStmtNode inWhichLoop = null;
    public boolean inLoop = false, isReturned = false;

    public Scope() {}
    public Scope(Scope parentScope) {
        this.parentScope = parentScope;
        this.inLoop = parentScope.inLoop;
        this.inWhichLoop = parentScope.inWhichLoop;
        this.inWhichClass = parentScope.inWhichClass;
    }
    public Scope(Scope parentScope, boolean isLoopScope) {
        this(parentScope);
        this.inLoop = isLoopScope;
    }
    public Scope(Scope parentScope, LoopStmtNode inWhichLoop) {
        this(parentScope);
        this.inLoop = true;
        this.inWhichLoop = inWhichLoop;
    }
    public Scope(Scope parentScope, Type returnType) {
        this.parentScope = parentScope;
        this.returnType = returnType;
        this.inWhichClass = parentScope.inWhichClass;
    }
    public Scope(Scope parentScope, ClassDefNode inWhichClass) {
        this.parentScope = parentScope;
        this.inWhichClass = inWhichClass;
    }

    public void addVar(String name, Type type) {
        varMember.put(name, type);
    }
    public boolean hasVarInThisScope(String name) {
        return varMember.containsKey(name);
    }
  public Type getVarType(String name) {
        if (varMember.containsKey(name))
            return varMember.get(name);
        else
            return parentScope != null ? parentScope.getVarType(name) : null;
    }

}