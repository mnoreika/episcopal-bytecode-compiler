import AbsSynTree.Constant;
import AbsSynTree.Definitions.FunctionDef;
import AbsSynTree.Expression;
import AbsSynTree.Expressions.Id;
import AbsSynTree.Expressions.Let;
import AbsSynTree.Expressions.Operation;
import AbsSynTree.Operators.Plus;
import AbsSynTree.Program;
import AbsSynTree.Constants.Integer;
import jasmin.;

public class Main {

    public static void main(String[] args) {
        Program test = new Program(new Id("Addition"),
                new Let(new FunctionDef(new Id("x"), new Expression[] {new Integer(1)}),
                        new Let(new FunctionDef(new Id("y"), new Expression[] {new Integer(41)}),
                        new Let(new FunctionDef(new Id("sum"), new Expression[] {
                                new Operation(new Plus(), new Id("x"), new Id("y"))}),
                                new Id("sum")))));



        String result  = test.compile();

        System.out.println(result);
    }
}
