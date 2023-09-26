import antlr.*;
import assembly.ASMModule;
import Utils.*;
import AST.*;
import IR.IRprogram;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import back.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import front.*;

public class Compiler {
    public static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        try {
//            CharStream input = CharStreams.fromStream(new FileInputStream("1.cpp"));
            CharStream input = CharStreams.fromStream(System.in);
//
            MxLexer lexer = new MxLexer(input);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MxParser parser = new MxParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListener());
            ParseTree tree = parser.program();
            ASTbuilder astBuilder = new ASTbuilder();
            ProgramNode ast = (ProgramNode) astBuilder.visit(tree);
            GlobalScope globalScope = new GlobalScope();
            new SymbolCollector(globalScope).visit(ast);
            new SemanticChecker(globalScope).visit(ast);

            IRprogram irprogram = new IRprogram();
            new IRBuilder(globalScope, irprogram).visit(ast);
            new CFGBuilder(irprogram);
            new Mem2Reg(irprogram).work();
//            String content1 = irprogram.toString();
//            writeToFile("1.ll", content1);

            ASMModule asmModule = new ASMModule();
            new InstSelector(asmModule).visit(irprogram);
//            String content_1 = asmModule.toString();
//            writeToFile("1.shit", content_1);
//            new RegAllocator(asmModule).work();
            new modernAllocator(asmModule).work();
            String content = asmModule.toString();
//            writeToFile("1.s", content);
            System.out.print(content);
        } catch (Throwable gb) {
            System.out.print(gb.toString());
        }
    }
}