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

    String file = args[0]; // python file passed as argument when running java code
    try{
    
    CharStream input = CharStreams.fromFileName(file);  //grabs all the input from the file


    deliverable1Lexer lexer = new deliverable1Lexer(input); //makes the lexer from the charStream

    CommonTokenStream stream = new CommonTokenStream(lexer);  //this gives us our tokens needed for creating the parser

    deliverable1Parser parser = new deliverable1Parser(stream); 

    ParseTree tree = parser.program();

    System.out.println("Parse Tree: ");

    System.out.println(tree.toStringTree(parser));
    }
    catch (IOException e)
    {
        System.err.println("error with reading input file");
    }
}
}