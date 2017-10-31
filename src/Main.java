import Compiler.Definitions.FunctionDef;
import Compiler.Distributions.Bernoulli;
import Compiler.Distributions.Beta;
import Compiler.Distributions.Flip;
import Compiler.Distributions.Normal;
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
import sun.misc.IOUtils;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Program function = new Program(new Id("Function"),
                new Let(new FunctionDef(new Id ("funcA"), new Id[] {new Id("x"), new Id("y")}, new Expression[] {
                        new Operation(new Multiply(), new FunctionArg(0, new Id("x")),
                                new Operation(new Plus(), new FunctionArg(0, new Id("x")), new FunctionArg(1, new Id("y"))))
                }),
                        new FunctionCall(new Id("funcA"), new Expression[] {new Integer("7"), new Integer("5")})));

        Program functionsNested = new Program(new Id("NestedFunctions"),
            new Let(new FunctionDef(new Id("funcA"), new Id[] {new Id("x")},
                    new Expression[] {new Operation(new Multiply(), new Id("x"), new Id("x"))}),
                    new Let(new FunctionDef(new Id("funcB"), new Id[] {new Id("x"), new Id("y")},
                            new Expression[] {new Operation(new Plus(), new Bernoulli(0.1f), new FunctionCall(new Id("funcA")))}),
                                    new FunctionCall(new Id("funcB"), new Expression[] {new Integer("2"), new Integer("5")}))));

        Program query = new Program(new Id("Query"),
                new Operation(
                        new Plus(),
                        new FunctionCall(new Id("f"), new Expression[] {new Integer("3"), new Integer("5")}),
                        new FunctionCall(new Id("g"), new Expression[] {new Integer("5")})),
                new FunctionDef[] {
                    new FunctionDef(new Id("f"), new Id[] {new Id("x"), new Id("y")},
                            new Expression[] {new Operation(new Plus(), new FunctionArg(0, new Id("x")), new FunctionArg(1, new Id("y"))),}),
                    new FunctionDef(new Id("g"), new Id[] {new Id("x")},
                            new Expression[] {new Id("x")})
                });



        Program bernoulli = new Program(new Id("Bernoulli"),
                new Bernoulli(0.7f));

        Program beta = new Program(new Id("Beta"),
                new Beta(4, 5));

        Program flip = new Program(new Id("Flip"),
                new Flip(0.2f));

        Program normal = new Program(new Id("Normal"),
                new Normal(10f, 12f));


        Assembler assembler = new Assembler();
        function.compile(assembler);

        String result = assembler.assemble();

        System.out.println(result);

    }
}
