// Generated from D:/Joe/DevJava/ComputerAlgebraSystem/src/UserInterface\Interpreter.g4 by ANTLR 4.8
package Antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InterpreterParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InterpreterVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InterpreterParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(InterpreterParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterpreterParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(InterpreterParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterpreterParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(InterpreterParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link InterpreterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(InterpreterParser.ExpressionContext ctx);
}