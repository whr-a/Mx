package Utils;

import AST.*;
import IR.entity.*;
import IR.IRtype.*;
public interface BuiltinElements {
    Type VoidType = new Type("void");
    Type IntType = new Type("int");
    Type BoolType = new Type("bool");
    Type StringType = new Type("string");
    Type NullType = new Type("null");
    Type ThisType = new Type("this");

    FuncDefNode PrintFunc = new FuncDefNode(null, VoidType, "print", StringType, 1);
    FuncDefNode PrintlnFunc = new FuncDefNode(null, VoidType, "println", StringType, 1);
    FuncDefNode PrintIntFunc = new FuncDefNode(null, VoidType, "printInt", IntType, 1);
    FuncDefNode PrintlnIntFunc = new FuncDefNode(null, VoidType, "printlnInt", IntType, 1);
    FuncDefNode GetStringFunc = new FuncDefNode(null, StringType, "getString", null, 0);
    FuncDefNode GetIntFunc = new FuncDefNode(null, IntType, "getInt", null, 0);
    FuncDefNode ToStringFunc = new FuncDefNode(null, StringType, "toString", IntType, 1);

    FuncDefNode StringLengthFunc = new FuncDefNode(null, IntType, "length", "string", null, 0);
    FuncDefNode StringSubStringFunc = new FuncDefNode(null, StringType, "substring", "string", IntType, 2);
    FuncDefNode StringParseIntFunc = new FuncDefNode(null, IntType, "parseInt", "string", null, 0);
    FuncDefNode StringOrdFunc = new FuncDefNode(null, IntType, "ord", "string", IntType, 1);

    FuncDefNode ArraySizeFunc = new FuncDefNode(null, IntType, "size", null, 0);

    IRBaseType irVoidType = new IRVoidType("void");
    IRBaseType irIntType = new IRIntType(32);
    IRBaseType irIntPtrType = new IRPtrType(irIntType,1);
    IRBaseType irNullType = new IRPtrType(irVoidType,1);
    IRBaseType irBoolType = new IRIntType(1);
    IRBaseType irCharType = new IRIntType(8);
//    IRBaseType irCondType = new IRIntType(1);
    IRBaseType irStringType = new IRPtrType(irCharType,1);

    IRVoidConst irVoidConst = new IRVoidConst();
//    IRCondConst irTrueConst = new IRCondConst(true);
//    IRCondConst irFalseConst = new IRCondConst(false);
    IRBoolConst irBoolTrueConst = new IRBoolConst(true);
    IRBoolConst irBoolFalseConst = new IRBoolConst(false);
    IRIntConst irIntConst0 = new IRIntConst(0);
    IRIntConst irIntConst1 = new IRIntConst(1);
    IRIntConst irIntConstn1 = new IRIntConst(-1);
    IRIntConst irIntConst4 = new IRIntConst(4);
}