package back;

import java.util.ArrayList;
import java.util.HashMap;

import AST.*;
import AST.expr.*;
import AST.stmt.*;
import IR.*;
import IR.IRtype.*;
import IR.entity.*;
import IR.inst.*;
import Utils.*;
public class IRBuilder implements ASTVisitor,BuiltinElements{
    public Scope currentScope;
    public GlobalScope globalScope;
    public IRfunction currentFunction = null;
    IRClassType currentClass = null;//目前所在的类
    IRbasicblock currentBlock = null;//目前所在的基本块
    public IRprogram root;
    HashMap<String, IRClassType> classTypeMap = new HashMap<>();
    HashMap<IRRegister, Integer> arraySizeMap = new HashMap<>();
    public IRBuilder(GlobalScope globalScope_,IRprogram root){
        this.globalScope = globalScope_;
        this.currentScope = globalScope_;
        this.root = root;
    }
    private IREntity getVal(ExprNode node) {
        if (node.value == null){
            assert node.storePtr != null;//断言node.storePtr不是null
            IRRegister val = new IRRegister("", ((IRPtrType) node.storePtr.type).pointToType());//创建这个实体
            currentBlock.addInst(new IRLoadInst(currentBlock, val, node.storePtr));
            node.value = val;
        }
        return node.value;
    }
    private IRBaseType typeTrans(Type type) {//将Type转换为IRType
        IRBaseType irType;
        switch (type.type) {
            case "int":
                irType = irIntType; break;
            case "bool":
                irType = irBoolType; break;
            case "string":
                irType = irStringType; break;
            case "void":
                irType = irVoidType; break;
            default://不是基础类型，就是类，类是指针类型
                irType = new IRPtrType(classTypeMap.get(type.type), 1);
        }
        if (type.dim > 0)//如果是数组
            irType = new IRPtrType(irType, type.dim);//如果是数组，那么就创建一个多维的type
        return irType;
    }
    private void addStore(IRRegister ptr, ExprNode rhs) {//添加store指令
        if (rhs.value instanceof IRNullConst)//如果是null
            rhs.value = new IRNullConst(((IRPtrType) ptr.type).pointToType());
        else currentBlock.addInst(new IRStoreInst(currentBlock, rhs.value, ptr));
    }
    private IRRegister stringCmp(String cmpName, IREntity lhs, IREntity rhs) {
        IRRegister temp = new IRRegister("", irBoolType);
        currentBlock.addInst(new IRCallInst(currentBlock, temp, irBoolType, cmpName, lhs, rhs));
        return temp;
    }
    @Override
    public void visit(ProgramNode node) {
        for(var def : node.deflist){
            if(def instanceof ClassDefNode){
                var classDef = (ClassDefNode)def;
                var classType = new IRClassType(classDef.name , classDef.varMember.size()<<2);
                classTypeMap.put(classDef.name, classType);
            }
        }//把所有存在的类都加入到classTypeMap中
        for(var def : node.deflist)
            if (def instanceof ClassDefNode) def.accept(this);

        for(var def : node.deflist)
            if (def instanceof VarDefNode) def.accept(this);

        for(var def : node.deflist)
            if (def instanceof FuncDefNode) def.accept(this);

        //所有的中间部分的块都已经建立
        if (root.initblock.insts.isEmpty()) {//如果全局变量都没有初始化
            root.initfunction = null;//不需要initFunc来初始化
        } else {
            root.initfunction.finish();//initFunc构造完成
            root.functions.addFirst(root.initfunction);//root.initFunc作为root函数列表的第一个
            IRbasicblock mainEntry = root.mainfunc.blocklist.get(0);
            mainEntry.insts.addFirst(new IRCallInst(mainEntry, irVoidType, "global_init"));
                //在main函数的第一个基本块中添加调用指令
        }
    }


    @Override
    public void visit(ClassDefNode node) {
        currentScope = new Scope(currentScope, node);
        currentClass = classTypeMap.get(node.name);
        root.classes.add(currentClass);//把当前类加入到root的结构体列表中
    
        node.varDefList.forEach(varDef -> varDef.accept(this)); // 进入每个成员变量

        if (node.builder != null) {//有构造函数
            currentClass.hasBuild = true;
            node.builder.accept(this);
        }
        node.funcDefList.forEach(funcDef -> funcDef.classname = node.name);//成员函数的类名设置
        node.funcDefList.forEach(funcDef -> funcDef.accept(this)); // 进入每个成员函数
        currentScope = currentScope.parentScope;//回到上一层作用域
        currentClass = null;
    }

    @Override
    public void visit(FuncDefNode node) {
        IRbasicblock.Cnt = 0;//每个函数重新对块的命名进行计数
        node.returnType.irType = typeTrans(node.returnType.type);
        String funcName = currentClass != null ? currentClass.name + "." + node.funcName : node.funcName;//函数名
        currentFunction = new IRfunction(funcName, node.returnType.irType);
        root.functions.add(currentFunction);
    
        currentScope = new Scope(currentScope, node.returnType.type);
        currentBlock = currentFunction.appendBlock(new IRbasicblock(currentFunction, "entry_", 0));
        currentFunction.entryBlock = currentBlock;//设置新的基本块entry_为entryBlock
        if (currentClass != null) {  //类的成员函数
            IRPtrType classPtrType = new IRPtrType(currentClass);
            IRRegister thisVal = new IRRegister("this", classPtrType);
            currentFunction.params.add(thisVal);//this加入参数列表

            IRRegister thisAddr = new IRRegister("this.addr", new IRPtrType(classPtrType));
            currentBlock.addInst(new IRAllocaInst(currentBlock, classPtrType, thisAddr, 0));
            currentBlock.addInst(new IRStoreInst(currentBlock, thisVal, thisAddr));
            currentScope.addIRVar("this", thisAddr);//将thisAddr加入当前作用域
        }
        if (node.args != null)node.args.accept(this);//访问参数列表


        currentFunction.exitBlock = new IRbasicblock(currentFunction, "return_", 0);
        currentBlock.terminalInst = new IRJumpInst(currentBlock, currentFunction.exitBlock);
        //terminalInst会传递。
        if (node.returnType.type.equals(VoidType)) {
            currentFunction.exitBlock.terminalInst = new IRRetInst(currentFunction.exitBlock, irVoidConst);
        } else {
            IRBaseType retValType = node.returnType.irType;
            currentFunction.retAddr = new IRRegister("retval", new IRPtrType(retValType));
            currentFunction.exitBlock.addInst(new IRAllocaInst(currentBlock, retValType, currentFunction.retAddr));

            IRRegister retVal = new IRRegister("ret", retValType);
            currentFunction.exitBlock.addInst(new IRLoadInst(currentBlock, retVal, currentFunction.retAddr));
            currentFunction.exitBlock.terminalInst = new IRRetInst(currentFunction.exitBlock, retVal);//直接设置返回指令
        }
        if (funcName.equals("main"))
            root.mainfunc = currentFunction;

        node.stmts.forEach(stmt -> stmt.accept(this));
        node.irFunc = currentFunction;
        currentFunction.finish();
        currentScope = currentScope.parentScope;
        currentFunction = null;
        currentBlock = null;
    }

    @Override
    public void visit(VarDefNode node) {
        node.units.forEach(unit -> unit.accept(this));
    }

    @Override
    public void visit(ConstructorNode node) {
        node.transToFuncDef().accept(this);
    }
    int idx = -1;
    @Override
    public void visit(functionDeclParamListNode node) {
        for (idx = 0; idx < node.args.size(); idx++) {//遍历函数参数
            VarDefUnitNode unit = node.args.get(idx);
            unit.accept(this);//访问参数定义
            //只有在accept过程中，idx才可能不是-1。
            IRRegister input = new IRRegister("", unit.type.irType);
            currentFunction.params.add(input);
            currentBlock.addInst(new IRStoreInst(currentBlock, input, currentScope.getIRVarptr(unit.name),
                idx + (currentClass == null ? 0 : 1)));
        }
        idx = -1;
    }

    @Override
    public void visit(TypeNode node) {
        node.irType = typeTrans(node.type);
    }
    
    @Override
    public void visit(VarDefUnitNode node) {
        node.type.accept(this);
        if (currentFunction != null) {  // 函数内部 参数声明/内部定义 取决于idx
            IRRegister definingPtr = new IRRegister(node.name + ".addr", new IRPtrType(node.type.irType));
            currentScope.addIRVar(node.name, definingPtr);  // 建立变量名和具体指针的映射
            currentBlock.addInst(new IRAllocaInst(currentBlock, node.type.irType, definingPtr,
                idx == -1 ? -1 : idx + (currentClass == null ? 0 : 1)));
            if (node.inival != null) {
                node.inival.accept(this);
                addStore(definingPtr, node.inival);
            } else if (node.type.type.isReferenceType() && idx == -1) //数组或类 赋初值null
                currentBlock.addInst(new IRStoreInst(currentBlock, new IRNullConst(node.type.irType), definingPtr));

        } else if (currentClass != null) {//类内成员变量
            currentClass.addmember(node.name, node.type.irType);
        } else {//全局变量
            IRGlobalvar gVar = new IRGlobalvar(node.name, node.type.irType);
            if (node.inival != null && node.inival instanceof AtomExprNode //初始化的值是一个原子式
                && !node.inival.type.equals(StringType) && !node.inival.str.equals("this")) {
                node.inival.accept(this);
                gVar.initVal =node.inival.value;
                globalScope.addIRVar(node.name, gVar);
            } else {
                gVar.initVal = node.type.irType.defaultValue();
                globalScope.addIRVar(node.name, gVar);
                if (node.inival != null) {
                    gVar.isCallInit = true;//设置需要调用init函数
                    //todo 查询是否真的需要isCallInit
                    IRfunction tmpFunc = currentFunction;
                    IRbasicblock tmpBlock = currentBlock;
                    currentFunction = root.initfunction;
                    currentBlock = root.initblock;//转到初始化函数的初始化块
                    node.inival.accept(this);
                    addStore(gVar, node.inival);
                    root.initblock = currentBlock;
                    currentFunction = tmpFunc;
                    currentBlock = tmpBlock;
                }
            }
            root.gVariables.add(gVar);
        }
    }

    @Override
    public void visit(AtomExprNode node) {
        if (node.type.equals(IntType)) {
            node.value = new IRIntConst(Integer.parseInt(node.str));
        } else if (node.type.equals(BoolType)) {
            node.value = new IRBoolConst(node.str.equals("true"));
        } else if (node.type.equals(StringType)) {
            IRStringConst strPtr = root.addStringConst(node.str.substring(1, node.str.length() - 1));
            node.value = strPtr;
        } else if (node.type.equals(NullType)) {
            node.value = new IRNullConst();
        } else {
            node.storePtr = currentScope.getIRVarptr("this");
        }
    }

    @Override
    public void visit(ArrayExp node) {
        node.name.accept(this);
        node.index.accept(this);
        IRRegister dest = new IRRegister("", getVal(node.name).type);
        currentBlock.addInst(new IRGetElementPtrInst(currentBlock, getVal(node.name), dest, getVal(node.index)));
        node.storePtr = dest;
    }

    @Override
    public void visit(assignExp node) {
        node.r.accept(this);
        node.l.accept(this);
        node.storePtr = node.l.storePtr;
        node.value = getVal(node.r);
        addStore(node.storePtr, node.r);
    }

    @Override
    public void visit(BinaryExp node) {
        node.lhs.accept(this);
        if (!node.op.equals("&&") && !node.op.equals("||"))
            node.rhs.accept(this);
        else {//短路求值
            IRRegister temp = new IRRegister(".shortCirTemp", new IRPtrType(irBoolType));
            currentBlock.addInst(new IRAllocaInst(currentBlock, irBoolType, temp));
            IRbasicblock rhsBlock = new IRbasicblock(currentFunction, "rhsBlock_", currentBlock.loopDepth);
            IRbasicblock trueBlock = new IRbasicblock(currentFunction, "trueBlock_", currentBlock.loopDepth);
            IRbasicblock falseBlock = new IRbasicblock(currentFunction, "falseBlock_", currentBlock.loopDepth);
            IRbasicblock nextBlock = new IRbasicblock(currentFunction, "shortCir.end_", currentBlock.loopDepth);
            nextBlock.terminalInst = currentBlock.terminalInst;
            //设置跳转条件
            currentBlock.terminalInst = node.op.equals("&&")
                ? new IRBranchInst(currentBlock, getVal(node.lhs), rhsBlock, falseBlock)//是"&&"的情况
                : new IRBranchInst(currentBlock, getVal(node.lhs), trueBlock, rhsBlock);//是"||"的情况
            currentBlock.isFinished = true;
            currentBlock = currentFunction.appendBlock(rhsBlock);
            node.rhs.accept(this);
            currentBlock.terminalInst = new IRBranchInst(currentBlock, getVal(node.rhs), trueBlock, falseBlock);
            currentBlock.isFinished = true;
            currentBlock = currentFunction.appendBlock(trueBlock);
            currentBlock.addInst(new IRStoreInst(currentBlock, irBoolTrueConst, temp));
            currentBlock.terminalInst = new IRJumpInst(currentBlock, nextBlock);
            currentBlock.isFinished = true;
            currentBlock = currentFunction.appendBlock(falseBlock);
            currentBlock.addInst(new IRStoreInst(currentBlock, irBoolFalseConst, temp));
            currentBlock.terminalInst = new IRJumpInst(currentBlock, nextBlock);
            currentBlock.isFinished = true;
            currentBlock = currentFunction.appendBlock(nextBlock);
            node.value = new IRRegister("", irBoolType);
            currentBlock.addInst(new IRLoadInst(currentBlock, (IRRegister) node.value, temp));
            return;
        }
        IRRegister dest = null;
        IRBaseType operandType = null;
        String op = null;
        if (node.lhs.type.equals(StringType) || node.rhs.type.equals(StringType)) {//有一方是StringType
            switch (node.op) {
                case "+":
                node.value = new IRRegister("", irStringType);
                currentBlock
                    .addInst(new IRCallInst(currentBlock, (IRRegister) node.value, irStringType, "string_add",
                        getVal(node.lhs), getVal(node.rhs)));//调用内建函数
                break;
                case "<":
                node.value = stringCmp("string_less", getVal(node.lhs), getVal(node.rhs));
                break;
                case "<=":
                node.value = stringCmp("string_lessOrEqual", getVal(node.lhs), getVal(node.rhs));
                break;
                case ">":
                node.value = stringCmp("string_greater", getVal(node.lhs), getVal(node.rhs));
                break;
                case ">=":
                node.value = stringCmp("string_greaterOrEqual", getVal(node.lhs), getVal(node.rhs));
                break;
                case "==":
                node.value = stringCmp("string_equal", getVal(node.lhs), getVal(node.rhs));
                break;
                case "!=":
                node.value = stringCmp("string_notEqual", getVal(node.lhs), getVal(node.rhs));
                break;
            }
        } else {
            IREntity lhs = getVal(node.lhs), rhs = getVal(node.rhs);
            switch (node.op) {
                case "+":
                if (lhs instanceof IRConst && rhs instanceof IRConst)
                    node.value = new IRIntConst(((IRIntConst) lhs).val + ((IRIntConst) rhs).val);
                op = "add"; break;
                case "-":
                if (lhs instanceof IRConst && rhs instanceof IRConst)
                    node.value = new IRIntConst(((IRIntConst) lhs).val - ((IRIntConst) rhs).val);
                op = "sub"; break;
                case "*":
                if (lhs instanceof IRConst && rhs instanceof IRConst)
                    node.value = new IRIntConst(((IRIntConst) lhs).val * ((IRIntConst) rhs).val);
                op = "mul"; break;
                case "/":
                if (lhs instanceof IRConst && rhs instanceof IRConst && ((IRIntConst) rhs).val != 0)
                    node.value = new IRIntConst(((IRIntConst) lhs).val / ((IRIntConst) rhs).val);
                op = "sdiv"; break;
                case "%":
                if (lhs instanceof IRConst && rhs instanceof IRConst)
                    node.value = new IRIntConst(((IRIntConst) lhs).val % ((IRIntConst) rhs).val);
                op = "srem"; break;
                case "<<":
                if (lhs instanceof IRConst && rhs instanceof IRConst)
                    node.value = new IRIntConst(((IRIntConst) lhs).val << ((IRIntConst) rhs).val);
                op = "shl"; break;
                case ">>":
                if (lhs instanceof IRConst && rhs instanceof IRConst)
                    node.value = new IRIntConst(((IRIntConst) lhs).val >> ((IRIntConst) rhs).val);
                op = "ashr"; break;
                case "&":
                if (lhs instanceof IRConst && rhs instanceof IRConst)
                    node.value = new IRIntConst(((IRIntConst) lhs).val & ((IRIntConst) rhs).val);
                op = "and"; break;
                case "|":
                if (lhs instanceof IRConst && rhs instanceof IRConst)
                    node.value = new IRIntConst(((IRIntConst) lhs).val | ((IRIntConst) rhs).val);
                op = "or"; break; 
                case "^":
                if (lhs instanceof IRConst && rhs instanceof IRConst)
                    node.value = new IRIntConst(((IRIntConst) lhs).val ^ ((IRIntConst) rhs).val);
                op = "xor"; break;
                case "<":
                if (lhs instanceof IRConst && rhs instanceof IRConst)
                    node.value = new IRBoolConst(((IRIntConst) lhs).val < ((IRIntConst) rhs).val);
                op = "slt"; break; 
                case "<=":
                if (lhs instanceof IRConst && rhs instanceof IRConst)
                    node.value = new IRBoolConst(((IRIntConst) lhs).val <= ((IRIntConst) rhs).val);
                op = "sle"; break;
                case ">":
                if (lhs instanceof IRConst && rhs instanceof IRConst)
                    node.value = new IRBoolConst(((IRIntConst) lhs).val > ((IRIntConst) rhs).val);
                op = "sgt"; break;
                case ">=":
                if (lhs instanceof IRConst && rhs instanceof IRConst)
                    node.value = new IRBoolConst(((IRIntConst) lhs).val >= ((IRIntConst) rhs).val);
                op = "sge"; break;
                case "==":
                if (lhs instanceof IRIntConst && rhs instanceof IRIntConst)
                    node.value = new IRBoolConst(((IRIntConst) lhs).val == ((IRIntConst) rhs).val);
                op = "eq"; break;
                case "!=":
                if (lhs instanceof IRIntConst && rhs instanceof IRIntConst)
                    node.value = new IRBoolConst(((IRIntConst) lhs).val != ((IRIntConst) rhs).val);
                op = "ne"; break;
            }
            if (node.value != null) return;
            switch (node.op) {
                case "+", "-", "*", "/", "%", "<<", ">>", "&", "|", "^" -> {
                    dest = new IRRegister("", irIntType);
                    currentBlock.addInst(new IRCalcInst(currentBlock, dest, lhs, rhs, op));
                }
                case "<", "<=", ">", ">=" -> {
                    operandType = irIntType;
                    dest = new IRRegister("", irBoolType);
                    currentBlock.addInst(new IRIcmpInst(currentBlock, operandType, dest, lhs, rhs, op));
                }
                case "==", "!=" -> {
                    operandType = node.lhs.type.equals(NullType) ? node.rhs.getIRType() : node.lhs.getIRType();
                    dest = new IRRegister("tmp", irBoolType);
                    currentBlock.addInst(new IRIcmpInst(currentBlock, operandType, dest, lhs, rhs, op));
                }
            }
            node.value = dest;
        }
    }

    @Override
    public void visit(FunctionExp node) {
        node.functionName.accept(this);
        FuncDefNode funcDef = node.functionName.funcDef;
        String funcRealName = funcDef.classname == null ? funcDef.funcName : funcDef.classname + "." + funcDef.funcName;
        funcDef.returnType.irType = typeTrans(funcDef.returnType.type);
        IRCallInst call = new IRCallInst(currentBlock, funcDef.returnType.irType, funcRealName);//先建立好

        if (funcDef == ArraySizeFunc) {//arraysize函数
            IRRegister array = ((memberExp) node.functionName).reg;
            node.value = new IRRegister("", irIntType);
            currentBlock.addInst(new IRCallInst(currentBlock, (IRRegister) node.value, irIntType, "__array_size",array));
        } else {
            if (funcDef == StringLengthFunc) call.funcName = "string_length";
            else if (funcDef == StringSubStringFunc) call.funcName = "string_substring";
            else if (funcDef == StringParseIntFunc) call.funcName = "string_parseInt";
            else if (funcDef == StringOrdFunc) call.funcName = "string_ord";
            if (funcDef.classname != null) { 
                if (node.functionName instanceof memberExp)
                    call.args.add(((memberExp) node.functionName).reg);
                else {  // 需要传入 this 指针
                        //这是在成员函数里面调用其它成员函数的情况
                    IRRegister thisPtr = currentScope.getIRVarptr("this");
                    IRRegister thisVal = new IRRegister("", ((IRPtrType) thisPtr.type).pointToType());
                    currentBlock.addInst(new IRLoadInst(currentBlock, thisVal, thisPtr));
                    call.args.add(thisVal);
                }
            }
            if (node.args != null) {
                node.args.accept(this);
                node.args.exprs.forEach(arg -> call.args.add(getVal(arg)));
            }
            if (funcDef.returnType.irType != irVoidType)
                call.callReg = new IRRegister("", funcDef.returnType.irType);
            currentBlock.addInst(call);
            node.value = call.callReg;
        }
    }

    

    @Override
    public void visit(prefixExp node) {
        node.exp.accept(this);
        IRRegister dest = null;
        String op = null;
        if(node.op){
            op = "add";
            dest = new IRRegister("", irIntType);
            currentBlock.addInst(new IRCalcInst(currentBlock, dest, getVal(node.exp), irIntConst1, op));
            currentBlock.addInst(new IRStoreInst(currentBlock, dest, node.exp.storePtr));
            node.value = dest;
            node.storePtr = node.exp.storePtr;
        }
        else{
            op = "sub";
            dest = new IRRegister("", irIntType);
            currentBlock.addInst(new IRCalcInst(currentBlock, dest, getVal(node.exp), irIntConst1, op));
            currentBlock.addInst(new IRStoreInst(currentBlock, dest, node.exp.storePtr));
            node.value = dest;
            node.storePtr = node.exp.storePtr;
        }
    }

    @Override
    public void visit(ternaryExp node) {
        node.condition.accept(this);
        IRbasicblock trueBlock = new IRbasicblock(currentFunction, "trueBlock_", currentBlock.loopDepth);
        IRbasicblock falseBlock = new IRbasicblock(currentFunction, "falseBlock_", currentBlock.loopDepth);
        IRbasicblock nextBlock = new IRbasicblock(currentFunction, "ternary.end_", currentBlock.loopDepth);
        IRBaseType types=typeTrans(node.type);
        node.storePtr = new IRRegister("",new IRPtrType(types));
        currentBlock.addInst(new IRAllocaInst(currentBlock, types, node.storePtr));
        IREntity cond = getVal(node.condition);
        nextBlock.terminalInst = currentBlock.terminalInst;
        currentBlock.terminalInst = new IRBranchInst(currentBlock, cond, trueBlock, falseBlock);
        currentBlock.isFinished = true;
        currentBlock = currentFunction.appendBlock(trueBlock);
        node.trueExp.accept(this);
        addStore(node.storePtr, node.trueExp);
        currentBlock.terminalInst = new IRJumpInst(currentBlock, nextBlock);
        currentBlock.isFinished = true;
        currentBlock = currentFunction.appendBlock(falseBlock);
        node.falseExp.accept(this);
        addStore(node.storePtr, node.falseExp);
        currentBlock.terminalInst = new IRJumpInst(currentBlock, nextBlock);
        currentBlock.isFinished = true;
        currentBlock = currentFunction.appendBlock(nextBlock);
        node.value = getVal(node);
    }

    @Override
    public void visit(UnaryExp node) {
        node.expr.accept(this);
        IRRegister dest = null;
        String op = null;
        switch (node.op) {
        case "++":
            op = "add";
            node.value = getVal(node.expr);
            dest = new IRRegister("", irIntType);
            currentBlock.addInst(new IRCalcInst(currentBlock, dest, node.value, irIntConst1, op));
            currentBlock.addInst(new IRStoreInst(currentBlock, dest, node.expr.storePtr));
            break;
        case "--":
            op = "sub";
            node.value = getVal(node.expr);
            dest = new IRRegister("", irIntType);
            currentBlock.addInst(new IRCalcInst(currentBlock, dest, node.value, irIntConst1, op));
            currentBlock.addInst(new IRStoreInst(currentBlock, dest, node.expr.storePtr));
            break;
        case "-":
            op = "sub";
            dest = new IRRegister("", irIntType);
            currentBlock.addInst(new IRCalcInst(currentBlock, dest, irIntConst0, getVal(node.expr), op));
            node.value = dest;
            break;
        case "~":  // x ^ -1
            op = "xor";
            dest = new IRRegister("", irIntType);
            currentBlock.addInst(new IRCalcInst(currentBlock, dest, getVal(node.expr), irIntConstn1, op));
            node.value = dest;
            break;
        case "!":
            assert node.expr.type.equals(BoolType);
            op = "xor";
            dest = new IRRegister("", irBoolType);
            currentBlock.addInst(new IRCalcInst(currentBlock, dest, getVal(node.expr), irBoolTrueConst, op));
            node.value = dest;
        }
    }

    @Override
    public void visit(VarExprNode node) {
        node.storePtr = currentScope.getIRVarptr(node.str);
        
        if (node.storePtr == null) { // 说明不是变量，是成员或者函数
            IRRegister thisAddr = (IRRegister) currentScope.getIRVarptr("this");
            if(thisAddr!=null) {
                IRBaseType objPtrType = ((IRPtrType) thisAddr.type).pointToType();
                IRBaseType objRealType = ((IRPtrType) objPtrType).pointToType();
                IRRegister thisVal = new IRRegister("this", objPtrType);//创建一个thisVal
                if (((IRClassType) objRealType).hasMember(node.str)) {//应当有这个成员
                    currentBlock.addInst(new IRLoadInst(currentBlock, thisVal, thisAddr));
                    node.storePtr = new IRRegister("this." + node.str,
                            new IRPtrType(((IRClassType) objRealType).gettype(node.str)));
                    currentBlock.addInst(new IRGetElementPtrInst(currentBlock, thisVal, node.storePtr, irIntConst0,
                            new IRIntConst(((IRClassType) objRealType).memberindex.get(node.str))));
                }
            }
        }
    }

    @Override
    public void visit(memberExp node) {
        node.obj.accept(this);
        IRBaseType objRealType = getVal(node.obj).type;
        node.reg = (IRRegister) node.obj.value;
        objRealType = ((IRPtrType) objRealType).pointToType();//获得这个成员指向的真正的类
        if (objRealType instanceof IRClassType) {
            IRBaseType memberType = ((IRClassType) objRealType).gettype(node.member);
            if (memberType != null) {
                node.storePtr = new IRRegister("", new IRPtrType(memberType));//创建一个指向成员的指针
                currentBlock.addInst(new IRGetElementPtrInst(currentBlock, getVal(node.obj), node.storePtr, irIntConst0,
                    new IRIntConst(((IRClassType) objRealType).memberindex.get(node.member))));//先0解引用，再加上偏移量
            }
        }
    }

    @Override
    public void visit(FuncCallArgsNode node) {
        node.exprs.forEach(expr -> expr.accept(this));
    }

    @Override
    public void visit(blockStmt node) {
        currentScope = new Scope(currentScope);
        node.stmts.forEach(stmt -> stmt.accept(this));
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(branchstmt node) {
        node.condition.accept(this);
        IREntity cond = getVal(node.condition);
        IRbasicblock lastBlock = currentBlock;
        IRbasicblock nextBlock = new IRbasicblock(currentFunction, "if.end_", currentBlock.loopDepth);
        nextBlock.terminalInst = currentBlock.terminalInst;
        IRbasicblock thenBlock = new IRbasicblock(currentFunction, "if.then_", nextBlock, currentBlock.loopDepth);
  
        currentScope = new Scope(currentScope);
        currentBlock.isFinished = true;
        currentBlock = currentFunction.appendBlock(thenBlock);
        node.thenstmt.accept(this);
        currentScope = currentScope.parentScope;
        if (node.elsestmt != null) {
            IRbasicblock elseBlock = new IRbasicblock(currentFunction, "if.else_", nextBlock, currentBlock.loopDepth);//创建一个elseBlock

            currentScope = new Scope(currentScope);
            currentBlock.isFinished = true;
            currentBlock = currentFunction.appendBlock(elseBlock);
            node.elsestmt.accept(this);
            currentScope = currentScope.parentScope;
            lastBlock.terminalInst = new IRBranchInst(lastBlock, cond, thenBlock, elseBlock);
        } else {
            lastBlock.terminalInst = new IRBranchInst(lastBlock, cond, thenBlock, nextBlock);
        }
        currentBlock.isFinished = true;
        currentBlock = currentFunction.appendBlock(nextBlock);
    }

    @Override
    public void visit(breakStmt node) {
        currentBlock.terminalInst = new IRJumpInst(currentBlock, currentScope.inWhichLoop.nextBlock);
        currentBlock.isFinished = true;
    }

    @Override
    public void visit(continueStmt node) {
        if (currentScope.inWhichLoop instanceof WhileStmtNode)
            currentBlock.terminalInst = new IRJumpInst(currentBlock, currentScope.inWhichLoop.condBlock);
        else currentBlock.terminalInst = new IRJumpInst(currentBlock, ((ForStmtNode) currentScope.inWhichLoop).stepBlock);
        currentBlock.isFinished = true;
    }

    @Override
    public void visit(ForStmtNode node) {
        currentScope = new Scope(currentScope, node);
        if (node.varDef != null) node.varDef.accept(this);
        if (node.init != null) node.init.accept(this);
        node.condBlock = new IRbasicblock(currentFunction, "for.cond_", currentBlock.loopDepth + 1);
        node.loopBlock = new IRbasicblock(currentFunction, "for.loop_", currentBlock.loopDepth + 1);
        node.stepBlock = new IRbasicblock(currentFunction, "for.step_", currentBlock.loopDepth + 1);
        node.nextBlock = new IRbasicblock(currentFunction, "for.end_", currentBlock.loopDepth);

        node.nextBlock.terminalInst = currentBlock.terminalInst;
        currentBlock.terminalInst = new IRJumpInst(currentBlock, node.condBlock);
        currentBlock.isFinished = true;
        currentBlock = currentFunction.appendBlock(node.condBlock);
        if (node.cond != null) {
            node.cond.accept(this);
            currentBlock.terminalInst = new IRBranchInst(currentBlock, getVal(node.cond), node.loopBlock, node.nextBlock);
        } else {
            currentBlock.terminalInst = new IRJumpInst(currentBlock, node.loopBlock);
        }
        currentBlock.isFinished = true;
        currentScope = new Scope(currentScope);
        currentBlock = currentFunction.appendBlock(node.loopBlock);
        node.stmts.accept(this);
        currentBlock.terminalInst = new IRJumpInst(currentBlock, node.stepBlock);
        currentBlock.isFinished = true;
        currentBlock = currentFunction.appendBlock(node.stepBlock);
        //step 不在for内部的作用域里面
        currentScope = currentScope.parentScope;
        if (node.step != null) node.step.accept(this);
        currentBlock.terminalInst = new IRJumpInst(currentBlock, node.condBlock);
        currentBlock.isFinished = true;
        currentBlock = currentFunction.appendBlock(node.nextBlock);
        currentScope = currentScope.parentScope;
        //相当于for里面一共有两层作用域，一层是for的，一层是for内部的
    }

    @Override
    public void visit(ExprStmt node) {
        if (node.expr != null) node.expr.accept(this);
    }

    @Override
    public void visit(returnStmt node) {
        if (node.expr != null) {
            node.expr.accept(this);
            addStore(currentFunction.retAddr, node.expr);
        }
        currentBlock.terminalInst = new IRJumpInst(currentBlock, currentFunction.exitBlock);
        currentBlock.isFinished = true;
    }

    @Override
    public void visit(WhileStmtNode node) {
        node.condBlock = new IRbasicblock(currentFunction, "while.cond_", currentBlock.loopDepth + 1);
        node.loopBlock = new IRbasicblock(currentFunction, "while.loop_", currentBlock.loopDepth + 1);
        node.nextBlock = new IRbasicblock(currentFunction, "while.end_", currentBlock.loopDepth);

        node.nextBlock.terminalInst = currentBlock.terminalInst;
        currentBlock.terminalInst = new IRJumpInst(currentBlock, node.condBlock);
        currentBlock.isFinished = true;
        currentBlock = currentFunction.appendBlock(node.condBlock);
        node.cond.accept(this);
        currentBlock.terminalInst = new IRBranchInst(currentBlock, getVal(node.cond), node.loopBlock, node.nextBlock);
        currentBlock = currentFunction.appendBlock(node.loopBlock);
        currentScope = new Scope(currentScope, node);
        node.stmts.accept(this);
        currentScope = currentScope.parentScope;
        currentBlock.terminalInst = new IRJumpInst(currentBlock, node.condBlock);
        currentBlock.isFinished = true;
        currentBlock = currentFunction.appendBlock(node.nextBlock);
    }
    private IREntity newArray(IRBaseType type, ArrayList<ExprNode> sizeList, int now_num) {
        sizeList.get(now_num).accept(this);
        IREntity cnt = getVal(sizeList.get(now_num));
        IREntity size;
        int sizeOfType = ((IRPtrType) type).pointToType().size;
        if (cnt instanceof IRIntConst) {
            size = new IRIntConst(((IRIntConst) cnt).val * sizeOfType + 4);
        } else {
            IRIntConst typeSize = new IRIntConst(sizeOfType);
            IRRegister tmpSize = new IRRegister("", irIntType);
            currentBlock.addInst(new IRCalcInst(currentBlock, tmpSize, cnt, typeSize, "mul"));
            //创建指令 cnt*typesize存到tmpSize里面
            size = new IRRegister("", irIntType);
            currentBlock.addInst(new IRCalcInst(currentBlock,(IRRegister) size, tmpSize, irIntConst4, "add"));
            //创建指令 tmpSize+Const(4)存到size里面
        }
        IRRegister ptr = new IRRegister("",type);
        currentBlock.addInst(new IRCallInst(currentBlock, ptr, new IRPtrType(type), "__newPtrArray", size, cnt));
        //调用函数,ptr为指向刚申请出的地址的指针
        if (now_num + 1 < sizeList.size()) {//如果后面还有size没有处理
            IRRegister idx_ = new IRRegister("", irIntPtrType);
            currentBlock.addInst(new IRAllocaInst(currentBlock, irIntType, idx_));//添加 idx_ alloca 指令
            currentBlock.addInst(new IRStoreInst(currentBlock, irIntConst0, idx_));//存一个0进去
            IRbasicblock condBlock = new IRbasicblock(currentFunction, "for.cond_", currentBlock.loopDepth + 1);
            IRbasicblock loopBlock = new IRbasicblock(currentFunction, "for.loop_", currentBlock.loopDepth + 1);
            IRbasicblock stepBlock = new IRbasicblock(currentFunction, "for.step_", currentBlock.loopDepth + 1);
            IRbasicblock nextBlock = new IRbasicblock(currentFunction, "for.end_", currentBlock.loopDepth);
            nextBlock.terminalInst = currentBlock.terminalInst;
            currentBlock.terminalInst = new IRJumpInst(currentBlock, condBlock);
            currentBlock.isFinished = true;

            currentBlock = currentFunction.appendBlock(condBlock);
            IRRegister cond = new IRRegister("", irBoolType);
            IRRegister iVal = new IRRegister("", irIntType);
            currentBlock.addInst(new IRLoadInst(currentBlock, iVal, idx_));//从idx_里面load,进入iVal
            currentBlock.addInst(new IRIcmpInst(currentBlock, irIntType, cond, iVal, cnt, "slt"));//比较iVal是否小于cnt,结果存入cond
            currentBlock.terminalInst = new IRBranchInst(currentBlock, cond, loopBlock, nextBlock);
            currentBlock.isFinished = true;

            currentBlock = currentFunction.appendBlock(loopBlock);
            IREntity iPtrVal = newArray(((IRPtrType) type).pointToType(),sizeList, now_num + 1);//type更深一层
            IRRegister iPtr = new IRRegister("", type);
            IRRegister iVal2 = new IRRegister("", irIntType);
            currentBlock.addInst(new IRLoadInst(currentBlock, iVal2, idx_));//从idx_里面load 进入iVal2
            currentBlock.addInst(new IRGetElementPtrInst(currentBlock, ptr, iPtr, iVal2));//ptr偏移iVal2,存入iPtr

            currentBlock.addInst(new IRStoreInst(currentBlock, iPtrVal, iPtr));//把iPtrVal store 进 iPtr
            currentBlock.terminalInst = new IRJumpInst(currentBlock, stepBlock);
            currentBlock.isFinished = true;

            currentBlock = currentFunction.appendBlock(stepBlock);
            IRRegister iRes = new IRRegister("", irIntType);
            IRRegister iVal3 = new IRRegister("", irIntType);
            currentBlock.addInst(new IRLoadInst(currentBlock, iVal3, idx_));
            currentBlock.addInst(new IRCalcInst(currentBlock, iRes, iVal3, irIntConst1, "add"));
            currentBlock.addInst(new IRStoreInst(currentBlock, iRes, idx_));
            //idx_指向的东西+1
            currentBlock.terminalInst = new IRJumpInst(currentBlock, condBlock);
            currentBlock.isFinished = true;

            currentBlock = currentFunction.appendBlock(nextBlock);
        }
        return ptr;
    }

    @Override
    public void visit(NewExprNode node) {
        IRBaseType type = typeTrans(node.type);
        if (node.dim > 0) {//new一个数组
            if(!node.sizes.isEmpty())
                node.value = newArray(type, node.sizes , 0);
            else
                node.value = new IRNullConst(type);//完全没有参数，那么实体是一个null
        } else {//new一个类
            IRClassType classType = (IRClassType) ((IRPtrType) type).pointToType();
            node.value = new IRRegister("", type);
            currentBlock.
                addInst(new IRCallInst(currentBlock, (IRRegister)node.value, type, "malloc", new IRIntConst(classType.size)));
            if (classType.hasBuild)
                currentBlock.
                    addInst(new IRCallInst(currentBlock, null, irVoidType, classType.name + "." + classType.name, node.value));
        }
    }
}