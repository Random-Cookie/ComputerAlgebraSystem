package UserInterface;

import Antlr.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	@SuppressWarnings("Duplicates")
	public static void main(String[] args){
		String input = "";
		if (args.length > 0){
			input = args[0];
		} else {
			try {
				System.out.println("Please input your expression:");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				input = br.readLine();
			} catch (IOException e){
				System.out.println("IO EXCEPTION:" + e.getMessage());
			}
		}


		try {
			CharStream charStream = CharStreams.fromString(input);
			InterpreterLexer interpreterLexer = new InterpreterLexer(charStream);
			CommonTokenStream commonTokenStream = new CommonTokenStream(interpreterLexer);
			InterpreterParser interpreterParser = new InterpreterParser(commonTokenStream);
			ListenerASTGenerator ASTGen = new ListenerASTGenerator();

			ParseTreeWalker.DEFAULT.walk(ASTGen, interpreterParser.expression());

			AbstractSyntaxNode AST = ASTGen.getAST();

			System.out.println("Expression:" );
			System.out.println("	" + AST.getExpression());
			AST.simplify();
			System.out.println("Simplified Expression:");
			System.out.println("	" + AST.getExpression());
		} catch (Exception e){
			System.out.println("ERROR:");
			System.out.println("    " + e.getLocalizedMessage());
		}

	}

	public static String getExpressionFromTree(InterpreterParser.ExpressionContext startContext){
		InterpreterVisitor visitor = new VisitorPrinter();
		return visitor.visit(startContext).toString();
	}
}
