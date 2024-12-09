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
    Stack<Integer> indents = new Stack<Integer>(); // stack to track indent levels
    List<org.antlr.v4.runtime.Token> pendingTokens = new ArrayList<>(); // tokens waiting to be processed

    {
        indents.push(0); // start with base indent at 0
    }

    int getIndentationCount(String whitespace) { // get the indentation count for a line
        int count = 0; 
        for (char ch : whitespace.toCharArray()) {
            if (ch == '\t') {
                count++; // count tabs
            }
        }
        return count; // return current indentation level
    }

    org.antlr.v4.runtime.Token createToken(int ttype, String text) { // creating token for antlr
        org.antlr.v4.runtime.CommonToken token = new org.antlr.v4.runtime.CommonToken(_tokenFactorySourcePair, ttype, DEFAULT_TOKEN_CHANNEL, getCharIndex(), getCharIndex());
        token.setLine(getLine()); 
        token.setCharPositionInLine(getCharPositionInLine()); 
        token.setText(text); 
        return token; 
    }

    void handleIndentation(String newLineText) {
        int nextChar = _input.LA(1); // peek next char
        StringBuilder buffer = new StringBuilder(); // buffer for whitespace

        // consume whitespace chars
        while (nextChar == '\t') {
            buffer.append((char)nextChar); // add tab to buffer
            _input.consume(); // consume char
            nextChar = _input.LA(1); // peek next char
        }

        String ws = buffer.toString(); // get indentation whitespace
        int currentIndent = getIndentationCount(ws); // current indent count
        int previousIndent = indents.peek(); // previous indent level on stack

        if (currentIndent > previousIndent) {
            // check for going up 2 in indent which is illegal
            if (currentIndent - previousIndent > 1) { // too big jump
                throw new org.antlr.v4.runtime.LexerNoViableAltException(this, _input, _tokenStartCharIndex, null); // throw error
            }

            // if indent is okay (less than or equal to 1)
            indents.push(currentIndent); // push new indent level
            pendingTokens.add(createToken(deliverable3Parser.INDENT, ws)); // add indent token
        } else if (currentIndent < previousIndent) {
            // allow multiple dedents (ex: end of nested structure where indent goes from 2 to 0)
            while (!indents.isEmpty() && indents.peek() > currentIndent) {
                indents.pop(); // pop higher indent levels
                pendingTokens.add(createToken(deliverable3Parser.DEDENT, "")); // add dedent token
            }
        }
    }

    @Override
    public org.antlr.v4.runtime.Token nextToken() {
        if (!pendingTokens.isEmpty()) {
            // return pending token if available
            return pendingTokens.remove(0); 
        }

        org.antlr.v4.runtime.Token t = super.nextToken(); // get next token from super
        if (t.getType() == NEWLINE) {
            if (_input.LA(1) != org.antlr.v4.runtime.IntStream.EOF) {
                handleIndentation(t.getText()); // handle indentation after newline
                if (!pendingTokens.isEmpty()) {
                    // return pending indentation or dedentation token
                    return pendingTokens.remove(0);
                }
            }
        }
        return t; // return token if no indent changes
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