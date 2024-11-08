import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.IOException;

public class PythonSubsetParserTest {
    public static void main(String[] args) throws Exception {
        // Check if the file path is passed as an argument
        if (args.length == 0) {
            System.out.println("Please provide a Python file as an argument.");
            return;
        }

        String filePath = args[0]; // Get the file path from the argument
        CharStream input = CharStreams.fromFileName(filePath); // Read input from the file

        // Create a lexer that feeds off of input CharStream
        deliverable1Lexer lexer = new deliverable1Lexer(input);

        // Create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create a parser that feeds off the tokens buffer
        deliverable1Parser parser = new deliverable1Parser(tokens);

        // Remove default error listeners
        parser.removeErrorListeners();

        // Add custom error listener
        parser.addErrorListener(new DiagnosticErrorListener());

        // Begin parsing at the start rule (replace 'start' with the correct rule name if needed)
        ParseTree tree = parser.program(); // Replace 'start' with the appropriate rule if necessary

        // Print the parse tree in LISP-style format
        System.out.println(tree.toStringTree(parser));

        // System.out.println("Parse Tree:");
        // printParseTree(tree, 0); // Start with an indentation level of 0
    }

    private static void printParseTree(ParseTree tree, int level) {
        // Print the node with indentation
        String indent = "  ".repeat(level);
        System.out.println(indent + tree.getClass().getSimpleName() + ": " + tree.getText());

        // If the node has children (not a leaf), recursively print each child
        for (int i = 0; i < tree.getChildCount(); i++) {
            printParseTree(tree.getChild(i), level + 1);
        }
    }
}
