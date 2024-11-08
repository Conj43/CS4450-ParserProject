grammar deliverable1;

program: statement* EOF;

statement
    : assignment
    | arithmeticAssignment
    ;

assignment
    : VARIABLE '=' expression
    ;

arithmeticAssignment
    : VARIABLE ('+=' | '-=' | '*=' | '/=') expression
    ;

expression
    : NUMBER
    | STRING
    | BOOLEAN
    | VARIABLE
    | list
    | expression ('+' | '-' | '*' | '/' | '%') expression
    ;

VARIABLE
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

NUMBER
    : DIGIT+ ('.' DIGIT+)?
    ;

STRING
    : '"' (~["\\] | '\\' .)* '"'
    | '\'' (~["\\] | '\\' .)* '\''
    ;

BOOLEAN
    : 'True'
    | 'False'
    ;

list
    : '[' (expression (',' expression)*)? ']'
    ;

fragment DIGIT : [0-9];

WS // whitespace
    : [ \t\r\n]+ -> skip
    ;

