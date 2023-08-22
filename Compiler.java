import antlr.*;
import Utils.*;
import AST.*;
import IR.IRprogram;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import front.*;
import back.IRBuilder;

public class Compiler {
    public static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {

//        try {
            CharStream input = CharStreams.fromStream(new FileInputStream("1.cpp"));
//            CharStream input = CharStreams.fromStream(System.in);
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
            String content = irprogram.toString();
            writeToFile("1.ll", content);
//            System.out.print(content);
//        }
//        catch (Throwable gb){
//            System.out.print(gb.toString());
//        }
    }
}