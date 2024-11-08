// Generated from deliverable1.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link deliverable1Parser}.
 */
public interface deliverable1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link deliverable1Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(deliverable1Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable1Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(deliverable1Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link deliverable1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd(deliverable1Parser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link deliverable1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd(deliverable1Parser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link deliverable1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(deliverable1Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link deliverable1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(deliverable1Parser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link deliverable1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiply(deliverable1Parser.MultiplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiply}
	 * labeled alternative in {@link deliverable1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiply(deliverable1Parser.MultiplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link deliverable1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(deliverable1Parser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link deliverable1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(deliverable1Parser.ParenExprContext ctx);
}