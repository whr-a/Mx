import antlr.*;
import Utils.*;
import AST.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import front.*;

public class Compiler {
    public static void main(String[] args) throws Exception {

//        try {
//            CharStream input = CharStreams.fromStream(new FileInputStream("1.in"));
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
//        }
//        catch (Throwable gb){
//            System.out.print(gb.toString());
//        }
    }
}