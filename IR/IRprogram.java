package IR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import IR.IRtype.*;
import IR.entity.*;
import Utils.*;
import IR.inst.*;
public class IRprogram implements BuiltinElements{
    public LinkedList<IRfunction> functions = new LinkedList<>();
    public ArrayList<IRClassType> classes = new ArrayList<>();
    public ArrayList<IRGlobalvar> gVariables = new ArrayList<>();

    public HashMap<String, IRStringConst> stringConst = new HashMap<>();
    
    public IRfunction initfunction = new IRfunction("global_init", irVoidType);//程序的初始化函数（全局）
    public IRfunction mainfunc;
    public IRbasicblock initblock = new IRbasicblock(initfunction, "entry_",0);//初始化函数的入口基本块

    public IRprogram(){
        initfunction.appendBlock(initblock);
        initfunction.exitBlock = new IRbasicblock(initfunction, "return_", 0);//设置初始化函数的退出函数
        initblock.terminalInst = new IRJumpInst(initblock, initfunction.exitBlock);
        initfunction.exitBlock.terminalInst = new IRRetInst(initfunction.exitBlock, irVoidConst);
    }
    public IRStringConst addStringConst(String str) {
        // transfer escape characters
        String val = "";
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c == '\\') {
                ++i;
                switch (str.charAt(i)) {
                    case 'n': val += '\n'; break;
                    case '\"': val += '\"'; break;
                    default: val += '\\';
                }
            } else val += c;
        }
        if (!stringConst.containsKey(val))
            stringConst.put(val, new IRStringConst(val));
        return stringConst.get(val);
    }

    @Override
    public String toString() {
        String ans = "";
        for (IRClassType structType : classes) {
            ans += structType + " = type {";
            for (int i = 0; i < structType.membertype.size(); ++i) {
                ans += structType.membertype.get(i);
                if (i != structType.membertype.size() - 1)ans += ", ";
            }
            ans += "}\n";
        }
        for (IRStringConst str : stringConst.values())
            ans += "@str." + String.valueOf(str.id) + " = private unnamed_addr constant ["
                + String.valueOf(str.val.length() + 1) + " x i8] c\"" + str.printStr() + "\"\n";
        for (IRGlobalvar globalVar : gVariables)
            ans += globalVar + " = dso_local global " + ((IRPtrType) globalVar.type).pointToType() + " " + globalVar.initVal + "\n";
        
        ans += "\ndeclare dso_local ptr @malloc(i32)\n";
        ans += "declare dso_local i32 @strlen(ptr)\n";
        ans += "declare void @print(ptr)\n";
        ans += "declare void @println(ptr)\n";
        ans += "declare void @printInt(i32)\n";
        ans += "declare void @printlnInt(i32)\n";
        ans += "declare ptr @getString()\n";
        ans += "declare i32 @getInt()\n";
        ans += "declare ptr @toString(i32)\n";
        ans += "declare ptr @string_substring(ptr, i32, i32)\n";
        ans += "declare i32 @string_parseInt(ptr)\n";
        ans += "declare i32 @string_ord(ptr, i32)\n";
        ans += "declare ptr @string_add(ptr, ptr)\n";
        ans += "declare i1 @string_equal(ptr, ptr)\n";
        ans += "declare i1 @string_notEqual(ptr, ptr)\n";
        ans += "declare i1 @string_less(ptr, ptr)\n";
        ans += "declare i1 @string_lessOrEqual(ptr, ptr)\n";
        ans += "declare i1 @string_greater(ptr, ptr)\n";
        ans += "declare i1 @string_greaterOrEqual(ptr, ptr)\n\n";
        ans += "declare i32 @__array_size(ptr)\n";
        ans += "declare ptr @__newPtrArray(i32, i32)\n";

        for (IRfunction func : functions) ans += func + "\n";
        return ans;
    }
}
