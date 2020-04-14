package Antlr;

import UserInterface.AbstractSyntaxNode;

public class ListenerASTGenerator extends InterpreterBaseListener{

	private AbstractSyntaxNode AST = new AbstractSyntaxNode("", false, false);

	public AbstractSyntaxNode getAST() {
		return AST;
	}

	@Override
	public void enterNumber(InterpreterParser.NumberContext ctx){
		if (ctx.getParent().getClass() != InterpreterParser.NumberContext.class) {
			AST.addNode(AST, new AbstractSyntaxNode(getNumber(ctx), true, false));
		}
	}

	@Override
	public void enterVariable(InterpreterParser.VariableContext ctx){
		if (ctx.UPPERCASE() != null){
			AST.addNode( AST, new AbstractSyntaxNode(ctx.UPPERCASE().getText(), true, false));
		} else {
			AST.addNode( AST, new AbstractSyntaxNode(ctx.LOWERCASE().getText(), true, false));
		}
	}

	@Override
	public void enterExpression(InterpreterParser.ExpressionContext ctx){
		if (ctx.SIN() != null){
			AST.addNode( AST, new AbstractSyntaxNode("sin", false, true));
		} else if (ctx.COS() != null){
			AST.addNode(AST, new AbstractSyntaxNode("cos", false, true));
		} else if (ctx.TAN() != null){
			AST.addNode( AST, new AbstractSyntaxNode("tan", false, true));
		} else if (ctx.COT() != null){
			AST.addNode( AST, new AbstractSyntaxNode("cot", false, true));
		} else if (ctx.SEC() != null){
			AST.addNode( AST, new AbstractSyntaxNode("sec", false, true));
		} else if (ctx.CSC() != null){
			AST.addNode( AST, new AbstractSyntaxNode("csc", false, true));
		} else if (ctx.POWER() != null){
			AST.addNode( AST, new AbstractSyntaxNode("^", false, false));
		} else if (ctx.MULTIPLY() != null){
			AST.addNode( AST, new AbstractSyntaxNode("*", false, false));
		} else if (ctx.DIVIDE() != null){
			AST.addNode( AST, new AbstractSyntaxNode("/", false, false));
		} else if (ctx.PLUS() != null){
			AST.addNode( AST, new AbstractSyntaxNode("+", false, false));
		} else if (ctx.MINUS() != null){
			AST.addNode( AST, new AbstractSyntaxNode("-", false, false));
		} else if (ctx.OBRACKET() != null){
			AST.addNode( AST, new AbstractSyntaxNode("()", false, false));
		}
	}

	private String getNumber(InterpreterParser.NumberContext ctx){
		if (ctx.number() == null){
			return ctx.DIGIT().getText();
		} else {
			return ctx.DIGIT().getText() + getNumber(ctx.number());
		}
	}
}
