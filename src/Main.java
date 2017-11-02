import Compiler.Constants.Boolean;
import Compiler.Definitions.FunctionDef;
import Compiler.Distributions.Bernoulli;
import Compiler.Distributions.Beta;
import Compiler.Expression;
import Compiler.Expressions.FunctionCall;
import Compiler.Expressions.Id;
import Compiler.Program;
import Compiler.Constants.Integer;
import Compiler.Constants.Float;
import Compiler.FunctionArg;
import Compiler.Assembler;

public class Main {

    public static void main(String[] args) {
        Program betaSample = new Program(new Id("BetaSample"),
                new Beta(new Float("4.0"), new Float("5.0")));


        Assembler assembler = new Assembler();
        betaSample.compile(assembler);

        String result = assembler.assemble();

        System.out.println(result);

    }
}