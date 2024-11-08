# CS4450-ParserProject

### Group Name

Parser Project Group CRD

### Group Members

1. Drew Distler
2. Ryan Goodbody
3. Connor Joyce

### Programming Language

Java

### Project Description

This project implements a parser for a set of python langauge utilizing ANTLR 4.  We used the Java extension of ANTLR so the files produced by ANTLR are java and our file for testing our parse tree is written in Java. We used ANTLR 
4.17.2  and this is usable with JDK 17 and newer. 

### Run

`antlr4 -Dlanguage=Java deliverable1.g4`

`javac -cp "C:\path\to\antlr-4.13.2-complete.jar;." PythonSubsetParserTest.java deliverable1Lexer.java deliverable1Parser.java deliverable1BaseListener.java deliverable1Listener.java`

`java -cp "C:\path\to\antlr-4.13.2-complete.jar;." PythonSubsetParserTest project_deliverable_1.py`
