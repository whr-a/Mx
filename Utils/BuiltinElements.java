package Utils;

import AST.*;

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
}