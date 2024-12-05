grammar Deliverable3;

program: statement* EOF;

statement
    : assignment
    | arithmeticAssignment
    | ifStatement
    | whileStatement
    | forStatement
    ;

TAB
    : '   '    #three spaces for TAB
    ;

assignment
    : VARIABLE '=' expression
    ;

arithmeticAssignment
    : VARIABLE ('+=' | '-=' | '*=' | '/=') expression
    ;

ifStatement
    : 'if' condition ':' '\n' TAB block
      ('elif' condition ':' '\n' TAB block)*
      ('else' ':' '\n' TAB block)?
    ;

whileStatement
    : 'while' condition ':' block
    ;

forStatement
    : 'for' VARIABLE 'in' iterable ':' block
    ;

block
    : (TAB statement)+
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