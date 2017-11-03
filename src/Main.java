import Compiler.Definitions.FunctionDef;
import Compiler.Distributions.Bernouilli;
import Compiler.Distributions.Beta;
import Compiler.Expressions.*;
import Compiler.Operators.Equals;
import Compiler.Operators.Plus;
import Compiler.Operators.Sub;
import Compiler.Program;
import Compiler.Constants.Integer;
import Compiler.Constants.Float;
import Compiler.Assembler;
import Compiler.Expression;

public class Main {

    /*
    * episcopal distAsVariable =
    * sample x where
    * x = Bernouilli 0.5
    * */
    public static void main(String[] args) {
        Program distAsVariable = new Program(new Id("DistAsVariable"),
                new Sample(new Bernouilli(new Float("0.5"))));

        Program betaSample = new Program(new Id("BetaSample"),
                new Sample(new Beta(new Float("14.5"), new Float("20.0"))));

        Program validObservation = new Program(new Id("ValidObservation"),
                new Observation(
                        new Operation(new Equals(), new Integer("42"), new Integer("42")),
                        new Operation(new Plus(), new Integer("42"), new Integer("42"))));

        Program floatSubtraction = new Program(new Id("FloatSubtraction"),
                new Operation(new Sub(), new Float("41.0"), new Float("1.0")));

        Program function = new Program(new Id("NestedFunctionsWithSharedVar"),
                new Let(new FunctionDef(new Id ("funcA"), new Id[] {new Id("a")}, new Expression[] {
                        new Let(new FunctionDef(new Id("funcB"), new Id[] {new Id("x"), new Id("y")}, new Expression[] {
                                new Operation(new Plus(),
                                        new Operation(new Plus(), new FunctionArg(0), new FunctionArg(1)),
                                        new Id("a"))
                        }),
                                new FunctionCall(new Id("NestedFunctionsWithSharedVar/funcB"), new Expression[] {
                                        new Integer("5"), new Integer("7")
                                }))
                }),
                        new FunctionCall(new Id("NestedFunctionsWithSharedVar/funcA"), new Expression[] {new Integer("30")})));

        Assembler assembler = new Assembler();
        function.compile(assembler);

        String result = assembler.assemble();

        System.out.println(result);

    }
}