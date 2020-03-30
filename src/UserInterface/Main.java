package UserInterface;

import Antlr.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import org.antlr.v4.runtime.*;

public class Main {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        String input = "(50)+10";
        //InputStream inputStream = new ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8")));
        try {

            CharStream charStream = CharStreams.fromString(input);
            InterpreterLexer interpreterLexer = new InterpreterLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(interpreterLexer);
            InterpreterParser interpreterParser = new InterpreterParser(commonTokenStream);

            System.out.println(getExpressionFromTree(interpreterParser.start()));

        } catch (Exception e){
            System.out.println("ERROR:");
            System.out.println("    " + e.getMessage());
        }
    }

    public static String getExpressionFromTree(InterpreterParser.StartContext startContext){
        InterpreterVisitor visitor = new VisitorPrinter();
        return visitor.visit(startContext).toString();
    }
}
