import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import Antlr.InterpreterParser;
import Antlr.InterpreterLexer;

public class Main {

    public static void main(String[] args) {
        InterpreterLexer lexer = new InterpreterLexer(CharStreams.fromString("1+2+5"));
        InterpreterParser parser = new InterpreterParser(new CommonTokenStream((lexer)));
        parser.start();
        System.out.println("Parser has executed");
    }
}
