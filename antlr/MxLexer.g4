lexer grammar MxLexer;
@header{package antlr;}
// Comments

LineComments: '//' ~[\r\n\u2028\u2029]* -> channel(HIDDEN);
BlockComments: '/*' .*? '*/' -> channel(HIDDEN);
// Keywords
Void:     'void';
Bool:     'bool';
Int:      'int';
String:   'string';
New:      'new';
Class:    'class';
Null:     'null';
True:     'true';
False:    'false';
This:     'this';
If:       'if';
Else:     'else';
For:      'for';
While:    'while';
Break:    'break';
Continue: 'continue';
Return:   'return';

// Operators
OpArrow: '->';
OpIncre: '++';
OpDecre: '--';
OpAnd: '&&';
OpOr: '||';
OpNot: '!';
OpShr: '>>';
OpShl: '<<';
OpBitAnd: '&';
OpBitOr: '|';
OpBitXor: '^';
OpBitCompl: '~';
OpAdd: '+';
OPSub: '-';
OPMul: '*';
OpDiv: '/';
OpMod: '%';
OpGeq: '>=';
OpLeq: '<=';
OpGt: '>';
OpLt: '<';
OpNeq: '!=';
OpEq: '==';
OpAssign: '=';
OpMemberAccess: '.';
LBracket: '[';
RBracket: ']';
LParenthese: '(';
RParenthese: ')';
LBrace: '{';
RBrace: '}';
SemiColon: ';';
Comma: ',';
Question: '?';
Colon: ':';
fragment Digit: [0-9];
fragment DigitExceptZero: [1-9];
fragment Letter: [a-zA-Z];
fragment IdentifierCharacter: [a-zA-Z0-9_];
fragment EscapeCharacter
    : 'n'
    | '\\'
    | '"';
fragment StringCharacter
    : ~["\\\n\r\u2028\u2029]
    | '\\' EscapeCharacter; 

//Identifier
Identifier: Letter IdentifierCharacter*;

// Literals
LogicalLiteral: True | False;
IntegerLiteral: ('0' | DigitExceptZero Digit*);
StringLiteral: '"' StringCharacter* '"';
NullLiteral: Null;

Whitespace
  :(' '
  | '\t'
  | '\u000B'
  | '\u000C'
  | '\u00A0'
  ) -> channel(HIDDEN);

NewLine
  :('\r'
  | '\n'
  | '\u2028'
  | '\u2029'
  ) -> channel(HIDDEN);