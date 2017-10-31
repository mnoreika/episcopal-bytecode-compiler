import Compiler.Definitions.FunctionDef;
import Compiler.Distributions.Bernoulli;
import Compiler.Distributions.Beta;
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
import Compiler.Assembler;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import jasmin.parser;

public class Main {

    public static void main(String[] args) {
        Program test = new Program(new Id("Addition"),
                new Let(new FunctionDef(new Id("x"), new Expression[] {new Integer("1")}),
                        new Let(new FunctionDef(new Id("y"), new Expression[] {new Integer("41")}),
                        new Let(new FunctionDef(new Id("sum"), new Expression[] {
                                new Operation(new Plus(), new Id("x"), new Id("y"))}),
                                new Id("sum")))));

        Program test2 = new Program(new Id("Function"),
                new Let(new FunctionDef(new Id ("funcA"), new Id[] {new Id("x"), new Id("y")}, new Expression[] {
                        new Operation(new Multiply(), new FunctionArg(0, new Id("x")),
                                new Operation(new Plus(), new FunctionArg(0, new Id("x")), new FunctionArg(1, new Id("y"))))
                }),
                        new FunctionCall(new Id("funcA"), new Expression[] {new Integer("7"), new Integer("5")})));


        Program bernoulli = new Program(new Id("Bernoulli"),
                new Bernoulli(0.7f));

        Program beta = new Program(new Id("Beta"),
                new Beta(4, 5));

        Assembler assembler = new Assembler();
        beta.compile(assembler);

        String result = assembler.assemble();

        System.out.println(result);

        try {
            PrintWriter writer = new PrintWriter("./output/test.j", "UTF-8");
            writer.write(result);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found or could not be created.");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unable to encode data.");
        }

        jasmin.Main a = new jasmin.Main();

        a.assemble("./output/test.j");
    }
}
