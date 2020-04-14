package Testing;

import Antlr.InterpreterLexer;
import Antlr.InterpreterParser;
import Antlr.ListenerASTGenerator;
import UserInterface.AbstractSyntaxNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class EqualityTesting {

	@SuppressWarnings("Duplicates")
	public static void main(String[] args){
		String input = "2*5+9+sin(50)";
		try {
			CharStream charStream = CharStreams.fromString(input);
			InterpreterLexer interpreterLexer = new InterpreterLexer(charStream);
			CommonTokenStream commonTokenStream = new CommonTokenStream(interpreterLexer);
			InterpreterParser interpreterParser = new InterpreterParser(commonTokenStream);
			ListenerASTGenerator ASTGen = new ListenerASTGenerator();

			ParseTreeWalker.DEFAULT.walk(ASTGen, interpreterParser.expression());
			AbstractSyntaxNode AST1 = ASTGen.getAST();
			AbstractSyntaxNode AST2 = ASTGen.getAST();
			System.out.println(AbstractSyntaxNode.treeEquality(AST1, AST2));

			String input2 = "5*2";

			CharStream charStream2 = CharStreams.fromString(input2);
			InterpreterLexer interpreterLexer2 = new InterpreterLexer(charStream2);
			CommonTokenStream commonTokenStream2 = new CommonTokenStream(interpreterLexer2);
			InterpreterParser interpreterParser2 = new InterpreterParser(commonTokenStream2);
			ListenerASTGenerator ASTGen2 = new ListenerASTGenerator();

			ParseTreeWalker.DEFAULT.walk(ASTGen2, interpreterParser2.expression());
			AST2 = ASTGen2.getAST();
			System.out.println(AbstractSyntaxNode.treeEquality(AST1, AST2));

		} catch (Exception e){
			System.out.println("ERROR:");
			System.out.println("    " + e.getLocalizedMessage());
		}
	}


}
