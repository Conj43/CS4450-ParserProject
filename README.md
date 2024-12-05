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

This project implements a parser for a set of python langauge utilizing ANTLR 4. We used the Java extension of ANTLR so the files produced by ANTLR are java and out parser is in Java.
ANTLR 4.13.2 and this is usable with JDK 8 and newer.



### Project Requirements

    - JDK 8 and newer
    - ANTLR 4.13.2
    - used classpath for including antlr library at compile and run time
    - can be run on MACOS, Linux, or Windows

## File Layout
- Deliverable_1 holds the grammar file and sample python file for the first deliverable.
- Deliverable_2 holds the grammar file and sample python file for the second deliverable.
- Deliverable_3 holds the grammar file and sample python file for the third deliverable. This is the directory where you can run our completed parser, using the commands below.

\n\n
Once you download or clone our repo, you can naviagte to the Deliverable_3 directory, and run the following commands to run the parser.
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
#### Describing this Command
- 'grun' is built in with ANTLR to test parsers and input data (you need to configure grun in your cp as well)
- 'deliverable3' is the name of our grammar
- 'program' is the name of our start rule
- '-gui' specifies the option to open a gui showing the parse tree which you can download (you can also do '-tree' to print the parse tree)
- '< project_deliverable_3.py' specifies to take the input from our sample python file to test the parser
<br><br>
Alternatively, run the following command then type some input to be tested by the parser into the terminal followed by Ctrl+D on macOS and Ctrl+Z on Windows. This will allow you to run the parser on your input.
```console
grun deliverable3 program -gui
```


