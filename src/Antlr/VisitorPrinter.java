package Antlr;

public class VisitorPrinter extends InterpreterBaseVisitor<String> {

	//Builder for string
	StringBuilder expression = new StringBuilder();

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
	public String visitVariable(InterpreterParser.VariableContext ctx) {
		if (ctx.UPPERCASE() == null) {
			return ctx.LOWERCASE().getText();
		} else {
			return ctx.UPPERCASE().getText();
		}

	}

	@Override
	public String visitExpression(InterpreterParser.ExpressionContext ctx) {
		if (ctx.expression() == null) {
			return visitChildren(ctx);
		} else {
			if (ctx.PLUS() == null) {
				return visit(ctx.term()) + "-" + visit(ctx.expression());
			} else {
				return visit(ctx.term()) + "+" + visit(ctx.expression());
			}
		}
	}

	@Override
	public String visitTerm(InterpreterParser.TermContext ctx) {
		if (ctx.term() == null) {
			return visitChildren(ctx);
		} else {

			if (ctx.MULTIPLY() == null) {
				return visit(ctx.exponent()) + "/" + visit(ctx.term());
			} else {
				return visit(ctx.exponent()) + "*" + visit(ctx.term());
			}
		}
	}

	@Override
	public String visitExponent(InterpreterParser.ExponentContext ctx) {
		if (ctx.expression() == null) {
			return visitChildren(ctx);
		} else {
			if (ctx.exponent() == null) {
				if (ctx.SIN() != null) {
					return "sin(" + visit(ctx.expression()) + ")";
				} else if (ctx.COS() != null) {
					return "cos(" + visit(ctx.expression()) + ")";
				} else if (ctx.TAN() != null){
					return "tan(" + visit(ctx.expression()) + ")";
				} else if (ctx.COT() != null){
					return "cot(" + visit(ctx.expression()) + ")";
				} else if (ctx.SEC() != null){
					return "sec(" + visit(ctx.expression()) + ")";
				} else {
					return "csc(" + visit(ctx.expression()) + ")";
				}
			} else {
				return visit(ctx.exponent()) + "^(" + visit(ctx.expression())+ ")";
			}
		}
	}

	@Override
	public String visitFactor(InterpreterParser.FactorContext ctx){
		if (ctx.expression() == null){
			return visitChildren(ctx);
		} else {
			return "(" + visit(ctx.expression()) + ")";
		}
	}
}
