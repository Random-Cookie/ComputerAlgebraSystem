package Testing;

import UserInterface.Main;
import Antlr.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class PrintTest {
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	private static final String ANSI_RED = "\u001B[31m";


	public static void main(String[] args){
		//setup

		System.out.println("Testing of VisitorPrinter Class");
		System.out.println("number:");
		runTest("0");
		runTest("9");
		runTest("569");
		runTest("99999999");
		System.out.println("variable:");
		runTest("a");
		runTest("Z");
		runTest("t");
		runTest("P");
		System.out.println("factor");
		runTest("(5)");
		runTest("(50)");
		System.out.println("exponent");
		runTest("5^(10)");
		runTest("25^(40)");
		runTest("sin(180)");
		runTest("cos(60)");
		runTest("tan(99)");
		runTest("cot(45)");
		runTest("sec(101)");
		runTest("csc(666)");
		System.out.println("term");
		runTest("52*10");
		runTest("10/5");
		runTest("40/sin(90)");
		runTest("1024/2^(4)");
		System.out.println("expression");
		runTest("5+10");
		runTest("11-11");
		runTest("5+10^(10)");
		runTest("15+19^(sin(180))");
		System.out.println("Overall  Tests");
		runTest("5*a+10^(6*a^(5+sin(80)))");
		runTest("sin(90)+cos(0)");
	}

	@SuppressWarnings("Duplicates")
	private static void runTest(String input){
		try {
			CharStream cs = CharStreams.fromString(input);
			InterpreterLexer il = new InterpreterLexer(cs);
			CommonTokenStream cts = new CommonTokenStream(il);
			InterpreterParser ip = new InterpreterParser(cts);
			System.out.println("	Expected:	" + input);
			String result = Main.getExpressionFromTree(ip.expression());
			System.out.println("	Result:		" + result);
			if (result.equals(input)){
				System.out.println(ANSI_GREEN + "	PASSED" + ANSI_RESET);
			} else {
				System.out.println(ANSI_RED + "	FAILED" + ANSI_RESET);
			}

		} catch (Exception e){
			System.out.println(ANSI_RED_BACKGROUND + "	ERROR:");
			System.out.println("    " + e.getMessage() + ANSI_RESET);
		}
	}
}
