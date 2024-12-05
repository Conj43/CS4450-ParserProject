grammar deliverable3;

program: statement* EOF;

COMMENT
    : '#' ~[\r\n]* -> skip
    ;
    
MULTILINE_COMMENT
    : '\'\'\'' .*? '\'\'\'' -> skip
    ;

WS
    : [ \r\n]+ -> skip
    ;

statement
    : assignment
    | arithmeticAssignment
    | ifStatement
    | whileStatement
    | forStatement
    ;

assignment
    : VARIABLE '=' expression
    ;

arithmeticAssignment
    : VARIABLE ('+=' | '-=' | '*=' | '/=') expression
    ;

ifStatement
    : 'if' condition ':' block
      ('elif' condition ':' block)*
      ('else' ':' block)?
    ;

whileStatement
    : 'while' condition ':' block
    ;

forStatement
    : 'for' VARIABLE 'in' (rangeFunction | VARIABLE) ':' block
    ;

rangeFunction
    : 'range' '(' expression (',' expression)* ')'
    ;

block
    : ('\t'+ statement '\t'*)+
    ;

condition
    : logicalCondition
    ;

logicalCondition
    : logicalCondition ('and' | 'or') logicalCondition     
    | expression comparisonOperator expression             
    | '(' logicalCondition ')'                             
    | 'not' term  
    | term
    ;

expression
    : term
    | expression ('+' | '-' | '*' | '/' | '%') term
    ;

term
    : NUMBER
    | STRING
    | BOOLEAN
    | VARIABLE
    | list
    | '(' expression ')'
    ;

comparisonOperator
    : '<'
    | '<='
    | '>'
    | '>='
    | '=='
    | '!='
    ;

VARIABLE
    : [a-zA-Z_][a-zA0-9_]*
    ;

NUMBER
    : '-'? DIGIT+ ('.' DIGIT+)?
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
