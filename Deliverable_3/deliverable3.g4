grammar deliverable3;

tokens {
    INDENT,
    DEDENT
}

@header {
    import java.util.Stack;
    import java.util.ArrayList;
    import java.util.List;
}

@lexer::members {
    Stack<Integer> indents = new Stack<Integer>();
    List<org.antlr.v4.runtime.Token> pendingTokens = new ArrayList<>();

    {
        indents.push(0);
    }

    int getIndentationCount(String whitespace) {
        int count = 0;
        for (char ch : whitespace.toCharArray()) {
            if (ch == ' ' || ch == '\t') {
                count++;
            }
        }
        return count;
    }

    org.antlr.v4.runtime.Token createToken(int ttype, String text) {
        org.antlr.v4.runtime.CommonToken token = new org.antlr.v4.runtime.CommonToken(_tokenFactorySourcePair, ttype, DEFAULT_TOKEN_CHANNEL, getCharIndex(), getCharIndex());
        token.setLine(getLine());
        token.setCharPositionInLine(getCharPositionInLine());
        token.setText(text);
        return token;
    }

    void handleIndentation(String newLineText) {
    int nextChar = _input.LA(1);
    StringBuilder wsBuf = new StringBuilder();

    while (nextChar == ' ' || nextChar == '\t') {
        wsBuf.append((char)nextChar);
        _input.consume();
        nextChar = _input.LA(1);
    }

    String ws = wsBuf.toString();
    int currentIndent = getIndentationCount(ws);
    int previousIndent = indents.peek();

    if (currentIndent > previousIndent) {
        // Check if indentation jumped more than one level upwards
        if (currentIndent - previousIndent > 1) {
            // Too big an indent jump - error

            throw new org.antlr.v4.runtime.LexerNoViableAltException(this, _input, _tokenStartCharIndex, null);
        }

        // Normal single-level indent
        indents.push(currentIndent);
        pendingTokens.add(createToken(deliverable3Parser.INDENT, ws));
    } else if (currentIndent < previousIndent) {
        // Allow multiple dedents at once without error
        // Dedent until we reach the new indentation level
        while (!indents.isEmpty() && indents.peek() > currentIndent) {
            indents.pop();
            pendingTokens.add(createToken(deliverable3Parser.DEDENT, ""));
        }
    } 
}



    @Override
    public org.antlr.v4.runtime.Token nextToken() {
        if (!pendingTokens.isEmpty()) {
            return pendingTokens.remove(0);
        }

        org.antlr.v4.runtime.Token t = super.nextToken();
        if (t.getType() == NEWLINE) {
            if (_input.LA(1) != org.antlr.v4.runtime.IntStream.EOF) {
                handleIndentation(t.getText());
                if (!pendingTokens.isEmpty()) {
                    return pendingTokens.remove(0);
                }
            }
        }
        return t;
    }

    @Override
    public void reset() {
        super.reset();
        pendingTokens.clear();
        indents.clear();
        indents.push(0);
    }
}

program
    : (statement | NEWLINE)* EOF
    ;

statement
    : assignment
    | arithmeticAssignment
    | ifStatement
    | whileStatement
    | forStatement
    ;

    COMMENT
    : '#' ~[\r\n]* -> skip
    ;

MULTILINE_COMMENT
    : '\'\'\'' .*? '\'\'\'' -> skip
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
    : INDENT (statement NEWLINE*)+ DEDENT | INDENT (statement NEWLINE*)+ DEDENT*
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
    : term (('+'|'-'|'*'|'/'|'%') term)*
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

list
    : '[' (expression (',' expression)*)? ']'
    ;

VARIABLE
    : [a-zA-Z_][a-zA-Z0-9_]*
    ;

NUMBER
    : '-'? DIGIT+ ('.' DIGIT+)?
    ;

fragment DIGIT : [0-9];

STRING
    : '"' (~["\\] | '\\' .)* '"'
    | '\'' (~['\\] | '\\' .)* '\''
    ;

BOOLEAN
    : 'True'
    | 'False'
    ;



WS
    : [ \t\r]+ -> skip
    ;

NEWLINE
    : ('\r\n'|'\n'| '\r')+
    ;