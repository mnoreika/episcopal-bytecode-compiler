import Compiler.Assembler;
import Compiler.Definitions.FunctionDef;
import Compiler.Expressions.*;
import Compiler.Operators.*;
import Compiler.Program;
import Compiler.Constants.Integer;
import Compiler.Constants.Float;
import Compiler.Expression;


import org.junit.Before;
import org.junit.Test;


public class FunctionTest {
    private Assembler assembler;
    private Tester tester = new Tester();

    @Before
    public void setup() {
        assembler = new Assembler();
    }

    /*
     * episcopal function =
     *   let funcA x y = x + x + y in funcA 15 12
     */
    @Test
    public void function() throws Exception {
        Program function = new Program(new Id("Function"),
                new Let(new FunctionDef(new Id ("funcA"), new Id[] {new Id("x"), new Id("y")}, new Expression[] {
                        new Operation(new Plus(), new FunctionArg(0),
                                new Operation(new Plus(), new FunctionArg(0), new FunctionArg(1)))
                }),
                        new FunctionCall(new Id("Function/funcA"), new Expression[] {new Integer("15"), new Integer("12")})));

        tester.assertCompilation(function, assembler, "42");
    }

    /*
     * episcopal nestedFunctions =
     *   let funcA x = 5 + x in
     *   let funcB y = funcA y + 20.5 in
     *   funcB 7
     */
    @Test
    public void nestedFunctions() throws Exception {
        Program function = new Program(new Id("NestedFunctions"),
                new Let(new FunctionDef(new Id ("funcA"), new Id[] {new Id("x")}, new Expression[] {
                        new Operation(new Plus(), new Integer("5"), new FunctionArg(0))
                }),
                        new Let(new FunctionDef(new Id("funcB"), new Id[] {new Id("y")}, new Expression[] {
                                new Operation(new Plus(),
                                        new FunctionCall(new Id("NestedFunctions/funcA"), new Expression[] {new FunctionArg(0)}),
                                        new Float("20.5"))
                        }),
                                new FunctionCall(new Id("NestedFunctions/funcB"), new Expression[] {new Integer("7")}))));

        tester.assertCompilation(function, assembler,"32.5");
    }

    /*
    * episcopal nestedFunctionsWithSharedVar =
    *   let funcA a  =
    *       let funcB x y = x + y + a in funcB 5 7
    *       in funcA 30
    *
    */
//    @Test
//    public void nestedFunctionsWithSharedVar() throws Exception {
//        Program function = new Program(new Id("NestedFunctionsWithSharedVar"),
//                new Let(new FunctionDef(new Id ("funcA"), new Id[] {new Id("a")}, new Expression[] {
//                        new Let(new FunctionDef(new Id("funcB"), new Id[] {new Id("x"), new Id("y")}, new Expression[] {
//                                new Operation(new Plus(),
//                                        new Operation(new Plus(), new FunctionArg(0), new FunctionArg(1)),
//                                        new Id("a"))
//                        }),
//                                new FunctionCall(new Id("NestedFunctionsWithSharedVar/funcB"), new Expression[] {
//                                        new Integer("5"), new Integer("7")
//                                }))
//                        }),
//                        new FunctionCall(new Id("NestedFunctionsWithSharedVar/funcA"), new Expression[] {new Integer("30")})));
//
//        tester.assertCompilation(function, assembler,"32.5");
//    }
}
