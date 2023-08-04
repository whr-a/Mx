package Utils;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class position {
    private int line,column;
    public position(int lin,int col){
        this.line = lin;
        this.column = col;
    }
    public position(ParserRuleContext ctx) {
        this(ctx.getStart());
    }
    public position(Token token) {
        this.line = token.getLine();
        this.column = token.getCharPositionInLine();
      }
}
