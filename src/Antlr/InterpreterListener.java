// Generated from D:/Joe/DevJava/ComputerAlgebraSystem/src/UserInterface\Interpreter.g4 by ANTLR 4.8
package Antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InterpreterParser}.
 */
public interface InterpreterListener extends ParseTreeListener {
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