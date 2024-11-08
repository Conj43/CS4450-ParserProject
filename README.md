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

This project implements a parser for a set of python langauge utilizing ANTLR 4. We used the Java extension of ANTLR so the files produced by ANTLR are java and our file for testing our parse tree is written in Java. We used ANTLR
4.13.2 and this is usable with JDK 8 and newer.

### Deliverable 1

    Parses
    - Arithmetic operators
            +, -, *, /, %,
    - Assignment operators
            =, +=, -=, *=, /=

### Project Requirements

    - JDK 8 and newer
    - ANTLR 4.13.2
    - used classpath for including antlr library at compile and run time
    - can be run on MACOS, Linux, or Windows

### Run

```console
antlr4 -Dlanguage=Java deliverable1.g4
```

```console
javac -cp "C:\path\to\antlr-4.13.2-complete.jar;." PythonSubsetParserTest.java deliverable1Lexer.java deliverable1Parser.java deliverable1BaseListener.java deliverable1Listener.java
```

```console
java -cp "C:\path\to\antlr-4.13.2-complete.jar;." PythonSubsetParserTest project_deliverable_1.py
```
