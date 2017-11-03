import Compiler.Distributions.Bernouilli;
import Compiler.Distributions.Beta;
import Compiler.Expressions.*;
import Compiler.Operators.Equals;
import Compiler.Operators.Less;
import Compiler.Operators.Plus;
import Compiler.Program;
import Compiler.Constants.Integer;
import Compiler.Constants.Float;
import Compiler.Assembler;

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

        Program less = new Program(new Id("less"),
                new Operation(new Less(), new Integer("4"), new Integer("9")));



        Assembler assembler = new Assembler();
        less.compile(assembler);

        String result = assembler.assemble();

        System.out.println(result);

    }
}