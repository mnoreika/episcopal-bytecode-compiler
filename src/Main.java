import Compiler.Definitions.FunctionDef;
import Compiler.Expression;
import Compiler.Expressions.FunctionCall;
import Compiler.Expressions.Id;
import Compiler.Expressions.Let;
import Compiler.Expressions.Operation;
import Compiler.Operators.Multiply;
import Compiler.Operators.Plus;
import Compiler.Program;
import Compiler.Constants.Integer;
import Compiler.FunctionArg;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Main {

    public static void main(String[] args) {
        Program test = new Program(new Id("Addition"),
                new Let(new FunctionDef(new Id("x"), new Expression[] {new Integer("1")}),
                        new Let(new FunctionDef(new Id("y"), new Expression[] {new Integer("41")}),
                        new Let(new FunctionDef(new Id("sum"), new Expression[] {
                                new Operation(new Plus(), new Id("x"), new Id("y"))}),
                                new Id("sum")))));

        Program test2 = new Program(new Id("Function"),
                new Let(new FunctionDef(new Id ("funcA"), new Id[] {new FunctionArg("x"), new FunctionArg("y")}, new Expression[] {
                        new Operation(new Multiply(), new FunctionArg(new Id ("funcA"), new Id("x")),
                                new Operation(new Plus(), new FunctionArg(new Id ("funcA"), new Id("x")), new FunctionArg(new Id ("funcA"), new Id("y"))))
                }),
                        new FunctionCall(new Id("funcA"), new Expression[] {new Integer("7"), new Integer("5")})));

        String result  = test2.compile();

        System.out.println(result);

        try {
            PrintWriter writer = new PrintWriter("./output/Addition" + ".j", "UTF-8");
            writer.write(result);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found or could not be created.");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unable to encode data.");
        }
    }
}
