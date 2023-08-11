parser grammar MxParser;
@header{package antlr;}
options {
  tokenVocab=MxLexer;
}

program: (functionDeclaration | classDeclaration | variableDeclaration)* EOF;

// Function
functionDeclaration
    : returnType Identifier '(' functionDeclParamList? ')' body=blockStatement
    ;
returnType
    : typename
    | Void
    ;
functionDeclParamList
    : (typename Identifier) (',' typename Identifier)*
    ;
functionCallArgList
    : (expression ',')* expression
    ;
blockStatement
    : '{' statement* '}'
    ;
// Class
classDeclaration
    : 'class' Identifier '{' (variableDeclaration | functionDeclaration | constructorDeclaration)* '}' ';'
    ;

constructorDeclaration
    : Identifier '(' ')' body=blockStatement
    ;
variableDeclaration
    : typename (initDeclarator ',')* initDeclarator ';'
    ;
initDeclarator
    : Identifier ('=' initializer=expression)?
    ;

// typename
//     : primitiveTypename # PrimitiveType
//     | identifier        # ClassType
//     | typename '[' ']'  # ArrayType
//     ;
typename
    : typenames ('[' ']')*
    ;
typenames
    : baseType | Identifier
    ;
baseType
    : Int | Bool | String
    ;
// statements
statement
    : blockStatement
    | variableDeclaration
    | branchStatement
    | forStatement | whileStatement
    | continueStatement | breakStatement | returnStatement
    | expressionStatement
    ;

branchStatement
    : If '(' condition=expression ')' ifStatement=statement (Else elseStatement=statement)?
    ;
whileStatement
    : While '(' expression ')' statement
    ;
//variableDeclaration本身就有;
//loopStatement
//    : While '(' condition=expression ')' body=statement                                              # WhileLoop
//    | For '(' init=variableDeclaration condition=expression? ';' step=expression? ')' body=statement # DeclForLoop
//    | For '(' init=expression? ';'     condition=expression? ';' step=expression? ')' body=statement # ExprForLoop
//    ;
forStatement : For '(' forInit expressionStatement expression? ')' statement;
forInit : variableDeclaration | expressionStatement;
//controlFlowStatement
//    : continueStatement
//    | breakStatement
//    | returnStatement
//    ;
expressionStatement
    : expression? ';'
    ;

continueStatement
    : Continue';'
    ;
breakStatement
    : Break';'
    ;
returnStatement
    : Return expression?';'
    ;



// Expressions
expression
    : '(' expression ')'                                                   # ParenthesesExpr
    | 'new' typename (newArrayUnit)* ('(' ')')?                            # NewExpr
    | expression op=OpMemberAccess Identifier                              # MemberExpr
    | expression '[' expression ']'                                        # ArrayExpr
    | expression '(' functionCallArgList? ')'                              # FuncExpr 
    // | expression op=('++' | '--')                                          # PostfixUpdateExpr
    | expression op=(OpIncre | OpDecre)                                    # UnaryExpr
    | <assoc=right>(op='++' | op='--') expression                          # PrefixUpdateExpr
    | <assoc=right> op=('!' | '-' | '~')                      r=expression # UnaryExpr
    | l=expression op=('*' | '/' | '%')                       r=expression # BinaryExpr
    | l=expression op=('+' | '-')                             r=expression # BinaryExpr
    | l=expression op=('<<' | '>>')                           r=expression # BinaryExpr
    | l=expression op=('<' | '>' | '<=' | '>=' | '==' | '!=') r=expression # BinaryExpr
    | l=expression op='&'                                     r=expression # BinaryExpr
    | l=expression op='|'                                     r=expression # BinaryExpr
    | l=expression op='^'                                     r=expression # BinaryExpr
    | l=expression op='&&'                                    r=expression # BinaryExpr
    | l=expression op='||'                                    r=expression # BinaryExpr
    | <assoc=right> a=expression op='?' b=expression ':'      c=expression # Ternaryexp
    | <assoc=right> l=expression '='                          r=expression # AssignExpr
    | primary                                                              # AtomExpr
    ;

newArrayUnit: '[' expression? ']';

primary
  : IntegerLiteral | StringLiteral | True | False | Null
  | Identifier
  | This
  ;
