package UserInterface;

import Antlr.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Tests {
    static int testNumber;
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        String sep = "----------";
        System.out.print('\n');
        System.out.println(sep + "REDUNDANCY TESTS" + sep);
        test("11+0", "11");
        test("0+11", "11");
        test("0-11", "11");
        test("11-0", "11");
        test("11*1", "11");
        test("1*11", "11");
        test("11/1", "11");

        System.out.print('\n');
        System.out.println(sep + "NUMBER EVALUATION" + sep);
        test("5+5", "10");
        test("128+128", "256");
        test("5-5", "0");
        test("5-10", "-5");
        test("5*5", "25");
        test("100*9", "900");
        test("500/5", "100");
        test("25/5", "5");
        test("1/2", "1/2");

        System.out.print('\n');
        System.out.println(sep + "COMBINED EVALUATION AND REDUNDANCY TESTS" + sep);
        test("1/3+3+3", "1/3+6");
        test("1/3-3-3", "1/3-6");
        test("1/3-3+3", "1/3");
        test("1/3+3-3", "1/3");
        test("1/3+3-6", "1/3-3");
        test("1/3-6+3", "1/3-3");

        System.out.print('\n');
        System.out.println(sep + "TRIGONOMETRIC REDUNDANCY" + sep);
        test("sin(90)", "1");
        test("sin(180)", "0");
        test("sin(270)","-1");
        test("sin(720)", "0");
        test("sin(630)", "1");
        test("cos(90)", "0");
        test("cos(180)", "-1");
        test("cos(360)", "1");
        test("cos(720)", "1");
        test("cos(630)", "0");
        test("csc(90)", "1");
        test("csc(270)", "-1");
        test("csc(630)", "1");
        test("sec(180)", "-1");
        test("sec(360)", "1");
        test("sec(720)", "1");
        test("tan(180)", "0");
        test("tan(720)", "0");
        test("cot(90)", "0");
        test("cot(630)", "0");

        System.out.print('\n');
        System.out.println(sep + "SIN / COS SIMPLIFICATION" + sep);
        test("sin(50)/cos(50)", "tan(50)");
        test("sin(5*x)/cos(5*x)", "tan(5*x)");
        test("cos(50)/sin(50)", "cot(50)");
        test("cos(5*x)/sin(5*x)", "cot(5*x)");

        System.out.print('\n');
        System.out.println(sep + "VARIABLE REORDERING" + sep);
        test("x*5", "5*x");
        test("5*x", "5*x");
        test("5+x*5", "5+5*x");

        System.out.print('\n');
        System.out.println(sep + "GATHERING LIKE TERMS" + sep);
        test("5*x+5*x", "10*x");
        test("5*x+5*x+5*y+5*y", "10*x+10*y");



        System.out.println("TESTS COMPLETE");
    }

    @SuppressWarnings("Duplicates")
    public static void test(String input, String expectedOutput){
        System.out.println("TEST " + testNumber + ":");
        testNumber++;
        try {
            CharStream charStream = CharStreams.fromString(input);
            InterpreterLexer interpreterLexer = new InterpreterLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(interpreterLexer);
            InterpreterParser interpreterParser = new InterpreterParser(commonTokenStream);
            ListenerASTGenerator ASTGen = new ListenerASTGenerator();

            ParseTreeWalker.DEFAULT.walk(ASTGen, interpreterParser.expression());

            AbstractSyntaxNode AST = ASTGen.getAST();

            System.out.println("Input: " + input);
            System.out.print("  Pre-Simplification: "  + AST.getExpression());
            System.out.print('\n');
            System.out.println("        " + input.equals(AST.getExpression()));

            AST.simplify();

            System.out.print("   Post-Simplification: " + AST.getExpression());
            System.out.print('\n');
            System.out.println("        " + expectedOutput.equals(AST.getExpression()));

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
