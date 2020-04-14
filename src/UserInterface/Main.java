package UserInterface;

import Antlr.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        test("1/3+3+3");
        test("1/3-3-3");
        test("1/3-3+3");
        test("1/3+3-3");
        test("1/3+3-6");
        test("1/3-6+3");

        test("sin(90+5*x)/cos(90+5*x)");

        System.out.println("DONE");
    }

    @SuppressWarnings("Duplicates")
    public static void test(String input){
        try {
            CharStream charStream = CharStreams.fromString(input);
            InterpreterLexer interpreterLexer = new InterpreterLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(interpreterLexer);
            InterpreterParser interpreterParser = new InterpreterParser(commonTokenStream);
            ListenerASTGenerator ASTGen = new ListenerASTGenerator();

            ParseTreeWalker.DEFAULT.walk(ASTGen, interpreterParser.expression());

            AbstractSyntaxNode AST = ASTGen.getAST();

            AST.printExpression();
            System.out.print('\n');

            AST.simplify();

            AST.printExpression();
            System.out.print('\n');

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
