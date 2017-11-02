import Compiler.Constants.Boolean;
import Compiler.Definitions.FunctionDef;
import Compiler.Distributions.Bernoulli;
import Compiler.Distributions.Beta;
import Compiler.Expression;
import Compiler.Expressions.FunctionCall;
import Compiler.Expressions.Id;
import Compiler.Expressions.Observation;
import Compiler.Expressions.Operation;
import Compiler.Operators.Equals;
import Compiler.Operators.Plus;
import Compiler.Program;
import Compiler.Constants.Integer;
import Compiler.Constants.Float;
import Compiler.FunctionArg;
import Compiler.Assembler;

public class Main {

    /*
    * episcopal observation =
    * observe 42 == 42 in 35 + 7
    * */
    public static void main(String[] args) {
        Program observation = new Program(new Id("Observation"),
                new Observation(
                        new Operation(new Equals(), new Integer("42"), new Integer("42")),
                        new Operation(new Plus(), new Integer("42"), new Integer("42"))));


        Assembler assembler = new Assembler();
        observation.compile(assembler);

        String result = assembler.assemble();

        System.out.println(result);

    }
}