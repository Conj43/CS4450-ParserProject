import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.IOException;

public class PythonSubsetParserTest {
    public static void main(String[] args) throws Exception {
    if(args.length <= 0)
    {
        System.out.println("you need to include the test python file");
        return;
    }

    String file = args[0]; //this is the argument provided when runnning this file
    try{
    
    String data = new String(File.readAllBytes(Paths.get(file))); //grabs all the data from the file

    CharStream fileData = CharStreams.fromString(data); //we use a CharStream which is included in the antlr library

    PythonSubsetLexer lexer = new PythonSubsetLexer(charStream); //makes the lexer from the charStream

    CommonTokenStream stream = new CommonTokenStream(lexer);  //this gives us our tokens needed for creating the parser

    PythonSubsetParser parser = new PythonSubsetParser(parser);

    ParseTree tree = parser.program();

    System.out.println("Parse Tree");

    System.out.println(tree.toStringTree(parser));

    }
    catch (IOException e)
    {
        System.err.println("error with reading input file");
    }
}
}