grammar Deliverable3;

program: statement* EOF;

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
    : 'for' VARIABLE 'in' iterable ':' block
    ;

block
    : (INDENT statement+ DEDENT)+
    ;

condition
    : logicalCondition
    ;

logicalCondition
    : logicalCondition ('and' | 'or') logicalCondition      
    | '(' logicalCondition ')'                              
    | 'not' term                                            
    | term comparisonOperator term                          
    | BOOLEAN                                                
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

iterable
    : list
    | 'range' '(' expression (',' expression)? ')'
    ;

list
    : '[' (expression (',' expression)*)? ']'
    ;

VARIABLE
    : [a-zA-Z_][a-zA-Z0-9_]*
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

fragment DIGIT : [0-9];

COMMENT
    : '#' ~[\r\n]* -> skip
    ;

    ;

MULTILINE_COMMENT
    : '\'\'\'' .*? '\'\'\'' -> skip
    ;

WS
    : [ \r\n]+ -> skip;

INDENT
    : '\t'
    ;

DEDENT
    : '\b'
    ;