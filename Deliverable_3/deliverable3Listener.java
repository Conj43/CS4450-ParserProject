// Generated from deliverable3.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link deliverable3Parser}.
 */
public interface deliverable3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(deliverable3Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(deliverable3Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(deliverable3Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(deliverable3Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(deliverable3Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(deliverable3Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#arithmeticAssignment}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticAssignment(deliverable3Parser.ArithmeticAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#arithmeticAssignment}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticAssignment(deliverable3Parser.ArithmeticAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(deliverable3Parser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(deliverable3Parser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(deliverable3Parser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(deliverable3Parser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(deliverable3Parser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(deliverable3Parser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#rangeFunction}.
	 * @param ctx the parse tree
	 */
	void enterRangeFunction(deliverable3Parser.RangeFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#rangeFunction}.
	 * @param ctx the parse tree
	 */
	void exitRangeFunction(deliverable3Parser.RangeFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(deliverable3Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(deliverable3Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(deliverable3Parser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(deliverable3Parser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#logicalCondition}.
	 * @param ctx the parse tree
	 */
	void enterLogicalCondition(deliverable3Parser.LogicalConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#logicalCondition}.
	 * @param ctx the parse tree
	 */
	void exitLogicalCondition(deliverable3Parser.LogicalConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(deliverable3Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(deliverable3Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(deliverable3Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(deliverable3Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(deliverable3Parser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(deliverable3Parser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link deliverable3Parser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(deliverable3Parser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link deliverable3Parser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(deliverable3Parser.ListContext ctx);
}