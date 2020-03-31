package Antlr;

public class VisitorPrinter extends InterpreterBaseVisitor<String> {

	@Override
	public String visitStart(InterpreterParser.StartContext ctx) {
		return visit(ctx.expression());
	}

	@Override
	public String visitNumber(InterpreterParser.NumberContext ctx) {
		if (ctx.number() == null) {
			return ctx.DIGIT().getText();
		} else {
			return ctx.DIGIT() + visit(ctx.number());
		}
	}

	@Override
	public String visitVariable(InterpreterParser.VariableContext ctx){
		if (ctx.UPPERCASE() == null){
			return ctx.LOWERCASE().getText();
		} else {
			return ctx.UPPERCASE().getText();
		}
	}

	@Override
	public String visitExpression(InterpreterParser.ExpressionContext ctx) {
		if (ctx.variable() != null){
			return visit(ctx.variable());
		} else if (ctx.number() != null){
			return visit(ctx.number());
		} else if (ctx.SIN() != null){
			return "sin(" + visit(ctx.expression(0)) + ")";
		} else if (ctx.COS() != null){
			return "cos(" + visit(ctx.expression(0)) + ")";
		} else if (ctx.TAN() != null){
			return "tan(" + visit(ctx.expression(0)) + ")";
		} else if (ctx.COT() != null){
			return "cot(" + visit(ctx.expression(0)) + ")";
		} else if (ctx.SEC() != null){
			return "sec(" + visit(ctx.expression(0)) + ")";
		} else if (ctx.CSC() != null){
			return "csc(" + visit(ctx.expression(0)) + ")";
		} else if (ctx.POWER() != null){
			return visit(ctx.expression(0)) + "^(" + visit(ctx.expression(1)) + ")";
		} else if (ctx.MULTIPLY() != null){
			return visit(ctx.expression(0)) + "*" + visit(ctx.expression(1));
		} else if (ctx.DIVIDE() != null){
			return visit(ctx.expression(0)) + "/" + visit(ctx.expression(1));
		} else if (ctx.PLUS() != null){
			return visit(ctx.expression(0)) + "+" + visit(ctx.expression(1));
		} else if (ctx.MINUS() != null){
			return visit(ctx.expression(0)) + "-" + visit(ctx.expression(1));
		} else {
			return "(" + visit(ctx.expression(0)) + ")";
		}
	}
}