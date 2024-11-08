grammar deliverable1;

program: expression EOF;

expression
    : expression '+' expression     # Add
    | expression '*' expression     # Multiply
    | '(' expression ')'            # ParenExpr
    | NUMBER                        # Number
    ;

NUMBER: [0-9]+;
WS: [ \t\r\n]+ -> skip;