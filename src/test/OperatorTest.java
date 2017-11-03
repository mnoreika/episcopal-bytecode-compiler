import Compiler.Assembler;
import Compiler.Operators.*;
import Compiler.Program;
import Compiler.Constants.Integer;
import Compiler.Constants.Float;
import Compiler.Constants.Boolean;
import Compiler.Expressions.Id;
import Compiler.Expressions.Operation;


import org.junit.Before;
import org.junit.Test;;

public class OperatorTest {
    private Assembler assembler;
    private Tester tester = new Tester();

    @Before
    public void setup() {
        assembler = new Assembler();
    }

    @Test
    public void integerAddition() throws Exception {
        Program integerAddition = new Program(new Id("IntegerAddition"),
                new Operation(new Plus(), new Integer("41"), new Integer("1")));

        tester.assertCompilation(integerAddition, assembler, "42");
    }

    @Test
    public void floatAddition() throws Exception {
        Program floatAddition = new Program(new Id("FloatAddition"),
                new Operation(new Plus(), new Float("41.0"), new Float("1.0")));

        tester.assertCompilation(floatAddition, assembler,"42.0");
    }

    @Test
    public void floatIntAddition() throws Exception {
        Program floatIntAddition = new Program(new Id("FloatIntAddition"),
                new Operation(new Plus(), new Float("41.0"), new Integer("1")));

        tester.assertCompilation(floatIntAddition, assembler, "42.0");
    }

    @Test
    public void intFloatAddition() throws Exception {
        Program intFloatAddition = new Program(new Id("IntFloatAddition"),
                new Operation(new Plus(), new Integer("5"), new Float("37.0")));

        tester.assertCompilation(intFloatAddition, assembler,"42.0");
    }

    @Test
    public void integerMultiplication() throws Exception {
        Program integerMultiplication = new Program(new Id("IntegerMultiplication"),
                new Operation(new Multiply(), new Integer("6"), new Integer("7")));

        tester.assertCompilation(integerMultiplication, assembler, "42");
    }

    @Test
    public void floatMultiplication() throws Exception {
        Program floatMultiplication = new Program(new Id("FloatMultiplication"),
                new Operation(new Multiply(), new Float("41.0"), new Float("1.0")));

        tester.assertCompilation(floatMultiplication, assembler,"41.0");
    }


    @Test
    public void floatIntMultiplication() throws Exception {
        Program floatIntMultiplication = new Program(new Id("FloatIntMultiplication"),
                new Operation(new Multiply(), new Float("41.0"), new Integer("1")));

        tester.assertCompilation(floatIntMultiplication, assembler, "41.0");
    }

    @Test
    public void intFloatMultiplication() throws Exception {
        Program intFloatMultiplication = new Program(new Id("IntFloatMultiplication"),
                new Operation(new Multiply(), new Integer("5"), new Float("37.0")));

        tester.assertCompilation(intFloatMultiplication, assembler,"185.0");
    }

    @Test
    public void integerSubtraction() throws Exception {
        Program integerSubtraction = new Program(new Id("IntegerSubtraction"),
                new Operation(new Sub(), new Integer("100"), new Integer("58")));

        tester.assertCompilation(integerSubtraction, assembler, "42");
    }

    @Test
    public void floatSubtraction() throws Exception {
        Program floatSubtraction = new Program(new Id("FloatSubtraction"),
                new Operation(new Sub(), new Float("41.0"), new Float("1.0")));

        tester.assertCompilation(floatSubtraction, assembler,"40.0");
    }


    @Test
    public void floatIntSubtraction() throws Exception {
        Program floatIntSubtraction = new Program(new Id("FloatIntSubtraction"),
                new Operation(new Sub(), new Float("41.0"), new Integer("1")));

        tester.assertCompilation(floatIntSubtraction, assembler, "40.0");
    }

    @Test
    public void intFloatSubtraction() throws Exception {
        Program intFloatSubtraction = new Program(new Id("IntFloatSubtraction"),
                new Operation(new Sub(), new Integer("5"), new Float("37.0")));

        tester.assertCompilation(intFloatSubtraction, assembler,"-32.0");
    }

    @Test
    public void integerDivision() throws Exception {
        Program integerDivision = new Program(new Id("IntegerDivision"),
                new Operation(new Div(), new Integer("294"), new Integer("7")));

        tester.assertCompilation(integerDivision, assembler, "42");
    }

    @Test
    public void floatDivision() throws Exception {
        Program floatDivision = new Program(new Id("FloatDivision"),
                new Operation(new Div(), new Float("41.0"), new Float("1.0")));

        tester.assertCompilation(floatDivision, assembler,"41.0");
    }

    @Test
    public void floatIntDivision() throws Exception {
        Program floatIntDivision = new Program(new Id("FloatIntDivision"),
                new Operation(new Div(), new Float("41.0"), new Integer("1")));

        tester.assertCompilation(floatIntDivision, assembler, "41.0");
    }

    @Test
    public void intFloatDivision() throws Exception {
        Program intFloatDivision = new Program(new Id("IntFloatDivision"),
                new Operation(new Div(), new Integer("5"), new Float("37.0")));

        tester.assertCompilation(intFloatDivision, assembler,"0.13513513");
    }

    @Test
    public void booleanResult() throws Exception {
        Program booleanResult = new Program(new Id("Boolean"), new Boolean("1"));

        tester.assertCompilation(booleanResult, assembler,"true");
    }

    @Test
    public void equalsOperator() throws Exception {
        Program equalsOperator = new Program(new Id("EqualsOperator"),
                new Operation(new Equals(), new Integer("42"), new Integer("42")));

        tester.assertCompilation(equalsOperator, assembler,"true");
    }

    @Test
    public void less() throws Exception {
        Program less = new Program(new Id("Less"),
                new Operation(new Less(), new Integer("4"), new Integer("9")));

        tester.assertCompilation(less, assembler, "true");
    }

    @Test
    public void greater() throws Exception {
        Program greater = new Program(new Id("Greater"),
                new Operation(new Greater(), new Integer("4"), new Integer("9")));

        tester.assertCompilation(greater, assembler, "false");
    }

    @Test
    public void and() throws Exception {
        Program and = new Program(new Id("And"),
                new Operation(new And(), new Boolean("1"), new Boolean("0")));

        tester.assertCompilation(and, assembler,"false");
    }

    @Test
    public void or() throws Exception {
        Program or = new Program(new Id("Or"),
                new Operation(new Or(), new Boolean("1"), new Boolean("0")));

        tester.assertCompilation(or, assembler,"true");
    }
}
