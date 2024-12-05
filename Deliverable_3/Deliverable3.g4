grammar deliverable3;

program: statement* EOF;

statement
    : assignment
    | arithmeticAssignment
    | ifStatement
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

block
    : (TAB statement)+
    ;

condition
    : logicalCondition
    ;

logicalCondition
    : logicalCondition ('and' | 'or') logicalCondition      # AndOrCondition
    | '(' logicalCondition ')'                              # ParenCondition
    | 'not' term                                            # NotCondition
    | expression comparisonOperator expression              # ComparisonCondition
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

COMMENT
    : '#' ~[\r\n]* -> skip
    ;


MULTILINE_COMMENT
    : '\'\'\'' .*? '\'\'\'' -> skip
    ;

WS
    : [ \r\n]+ -> skip
    ;