package assembly;

import assembly.operand.*;
import java.util.ArrayList;

public class ASMModule {
    public ArrayList<GlobalValue> globalValues = new ArrayList<GlobalValue>();
    public ArrayList<GlobalString> globalStrings = new ArrayList<GlobalString>();
    public ArrayList<ASMFunction> functions = new ArrayList<ASMFunction>();

    public String toString() {
        String ret = "";
        if (!globalValues.isEmpty())                    ret += "  .section .data\n";
        for (GlobalValue globalValue : globalValues)    ret += globalValue;
        if (!globalStrings.isEmpty())                   ret += "  .section .rodata\n";
        for (GlobalString globalString : globalStrings) ret += globalString;
        for (ASMFunction function : functions)          ret += function;
        return ret;
    }
}