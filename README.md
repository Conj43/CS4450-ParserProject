# CS4450-ParserProject

### Group Name

Parser Project Group CRD

### Group Members

1. Drew Distler
2. Ryan Goodbody
3. Connor Joyce

### GitHub Link

https://github.com/Conj43/CS4450-ParserProject

### Programming Language

Java

### Project Description

This project implements a parser for a subset of the Python language using ANTLR 4. The parser is designed to recognize grammar constructs defined in our project deliverables and produce a parse tree for given Python input code. We chose the Java target for ANTLR, so the generated parser and related classes are Java-based. Through the different deliverables we were able to implement functionality for parsing: Basic Arithmetic, Assignment Operations, Conditional Statements, Loop Constructs, Nested Structures, Lists, and Comments



### Project Requirements

    - JDK 8 and newer
    - ANTLR 4.13.2
    - used classpath for including antlr library at compile and run time
    - can be run on MACOS, Linux, or Windows

## File Layout
- Deliverable_1 holds the grammar file and sample python file for the first deliverable.
- Deliverable_2 holds the grammar file and sample python file for the second deliverable.
- Deliverable_3 holds the grammar file and sample python file for the third deliverable. This is the directory where you can run our completed parser, using the commands below.

### Run to Generate Java Files Based on Grammar 

```console
antlr4 deliverable3.g4
```

### Compile Java Files

##### Windows 
```console
javac -cp "C:\path\to\antlr-4.13.2-complete.jar;." deliverable3*.java
```
or if you have class path setup
```console
javac deliverable3*.java
```
##### macOS/Linux
```console
javac -cp .:\path\to\antlr-4.13.2-complete.jar deliverable3*.java
```
or if you have class path setup
```console
javac deliverable3*.java
```
### Run Parser on Deliverable 3 Python File
```console
grun deliverable3 program -gui < project_deliverable_3.py
```

Alternatively, run the following command to and type sample input into the terminal followed by Ctrl+D on macOS and Ctrl+Z on Windows followed by an enter. This will allow you to run any input on the parser.
```console
grun deliverable3 program -gui
```

### Demo Video Link
https://youtu.be/hyS-cucHXzA


