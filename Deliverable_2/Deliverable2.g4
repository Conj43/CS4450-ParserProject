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
    : 'if' condition COLON block
      ('elif' condition COLON block)*
      ('else' COLON block)?
    ;

block
    : '{' statement* '}'
    ;

condition
    : logicalCondition
    ;

logicalCondition
    : logicalCondition ('and' | 'or') logicalCondition       # AndOrCondition
    | '(' logicalCondition ')'                                 # ParenCondition
    | 'not' term                                                # NotCondition
    | expression comparisonOperator expression                  # ComparisonCondition
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

COLON: ':';  

WS
    : [ \t\r\n]+ -> skip
    ;