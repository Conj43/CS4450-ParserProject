grammar deliverable2;

program: statement* EOF;

statement
    : assignment
    | arithmeticAssignment
    | ifStatement
    ;

assignment
    : VARIABLE '=' expression
    ;

arithmeticAssignment
    : VARIABLE ('+=' | '-=' | '*=' | '/=') expression
    ;

ifStatement
    : 'if' conditionBlock ('elif' conditionBlock)* ('else' block)?
    ;

conditionBlock
    : '(' condition ')' block
    ;

block
    : '{' statement*  '}'
    ;

condition
    : expression comparisonOperator expression
    | 'not' condition
    | condition ('and' | 'or') condition
    ;

comparisonOperator
    : '<'
    | '<='
    | '>'
    | '>='
    | '=='
    | '!='
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

