// Generated from D:/Joe/DevJava/ComputerAlgebraSystem/src\Interpreter.g4 by ANTLR 4.8
package Antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InterpreterParser}.
 */
public interface InterpreterListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InterpreterParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(InterpreterParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterpreterParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(InterpreterParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterpreterParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(InterpreterParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterpreterParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(InterpreterParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterpreterParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(InterpreterParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterpreterParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(InterpreterParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterpreterParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(InterpreterParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterpreterParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(InterpreterParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterpreterParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(InterpreterParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterpreterParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(InterpreterParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterpreterParser#exponent}.
	 * @param ctx the parse tree
	 */
	void enterExponent(InterpreterParser.ExponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterpreterParser#exponent}.
	 * @param ctx the parse tree
	 */
	void exitExponent(InterpreterParser.ExponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(InterpreterParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterpreterParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(InterpreterParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link InterpreterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(InterpreterParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InterpreterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(InterpreterParser.ExpressionContext ctx);
}