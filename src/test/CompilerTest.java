import Compiler.Constants.Boolean;
import Compiler.Constants.Integer;
import Compiler.Constants.Float;
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
import Compiler.Operators.Equals;
import Compiler.Operators.Plus;
import Compiler.Program;
import Compiler.Assembler;
import Compiler.FunctionArg;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CompilerTest {
    private Assembler assembler;

    @Before
    public void setup() {
        assembler = new Assembler();
    }

    @Test
    public void integerAddition() throws Exception {
       Program addition = new Program(new Id("integerAddition"),
               new Operation(new Plus(), new Integer("41"), new Integer("1")));

       assertCompilation(addition, "42");
    }

    @Test
    public void floatAddition() throws Exception {
        Program addition = new Program(new Id("floatAddition"),
                new Operation(new Plus(), new Float("41.0"), new Float("1.0")));

        assertCompilation(addition, "42.0");
    }

    @Test
    public void floatIntAddition() throws Exception {
        Program addition = new Program(new Id("floatIntAddition"),
                new Operation(new Plus(), new Float("41.0"), new Integer("1")));

        assertCompilation(addition, "42.0");
    }

    @Test
    public void intFloatAddition() throws Exception {
        Program addition = new Program(new Id("intFloatAddition"),
                new Operation(new Plus(), new Integer("5"), new Float("37.0")));

        assertCompilation(addition, "42.0");
    }

    @Test
    public void booleanResult() throws Exception {
        Program addition = new Program(new Id("boolean"), new Boolean("1"));

        assertCompilation(addition, "true");
    }

    @Test
    public void equalsOperator() throws Exception {
        Program equalsOperator = new Program(new Id("equalsOperator"),
                new Operation(new Equals(), new Integer("42"), new Integer("42")));

        assertCompilation(equalsOperator, "true");
    }

    @Test
    public void function() throws Exception {
        Program function = new Program(new Id("function"),
                new Let(new FunctionDef(new Id ("funcA"), new Id[] {new Id("x"), new Id("y")}, new Expression[] {
                        new Operation(new Plus(), new FunctionArg(0, new Id("x")),
                                new Operation(new Plus(), new FunctionArg(0, new Id("x")), new FunctionArg(1, new Id("y"))))
                }),
                        new FunctionCall(new Id("Function/funcA"), new Expression[] {new Integer("15"), new Integer("12")})));

        assertCompilation(function, "42");
    }

    /*
    * episcopal nestedFunctions =
    *   let funcA x = 5 + x in
    *   let funcB y = funcA y + 20.5 in
    *   funcB 7
    * */
    @Test
    public void nestedFunctions() throws Exception {
        Program function = new Program(new Id("nestedFunctions"),
                new Let(new FunctionDef(new Id ("funcA"), new Id[] {new Id("x")}, new Expression[] {
                        new Operation(new Plus(), new Integer("5"), new FunctionArg(0, new Id("x")))
                }),
                new Let(new FunctionDef(new Id("funcB"), new Id[] {new Id("y")}, new Expression[] {
                        new Operation(new Plus(),
                                new FunctionCall(new Id("nestedFunctions/funcA"), new Expression[] {new FunctionArg(0, new Id("y"))}),
                                new Float("20.5"))
                }),
                        new FunctionCall(new Id("nestedFunctions/funcB"), new Expression[] {new Integer("7")}))));

        assertCompilation(function, "32.5");
    }

    @Test
    public void bernoulliSample() throws Exception {
        Program bernoulliSample = new Program(new Id("bernoulliSample"),
                new Bernoulli(new Float("0.7")));

        assertVariedCompilation(bernoulliSample, new String[] {"0", "1"});
    }

    @Test
    public void betaSample() throws Exception {
        Program betaSample = new Program(new Id("BetaSample"),
                new Beta(new Float("4.0"), new Float("5.0")));

        assertCompilationInRange(betaSample, 0, 1);
    }

    @Test
    public void flipSample() throws Exception {
        Program flipSample = new Program(new Id("FlipSample"),
                new Flip(new Float("0.7")));

        assertVariedCompilation(flipSample, new String[] {"true", "false"});
    }

    @Test
    public void normalSample() throws Exception {
        Program normalSample = new Program(new Id("NormalSample"),
                new Normal(new Float("10.0"), new Float("4.0")));

        assertCompilationInRange(normalSample, 0, 100);
    }

    private void assertCompilationInRange(Program program, int rangeStart, int rangeEnd) {
        String outcome = compileAndRunProgram(program);
        java.lang.Float result = java.lang.Float.valueOf(outcome);

        System.out.println(result);
        assertTrue(result >= rangeStart);
        assertTrue(result <= rangeEnd);
    }

    private void assertVariedCompilation(Program program, String[] possibleOutcomes) {
        String outcome = compileAndRunProgram(program);

        boolean matchFound = false;

        for (int i = 0; i < possibleOutcomes.length; i++) {
            if (outcome.equals(possibleOutcomes[i])) {
                matchFound = true;
            }
        }

        assertTrue(matchFound);
    }

    private void assertCompilation(Program program, String expectedOutcome) {
        String outcome = compileAndRunProgram(program);

        /* Assert if the outcome is as expected */
        assertEquals(expectedOutcome, outcome);
    }

    private String compileAndRunProgram(Program program) {
        /* Compile the program */
        program.compile(assembler);
        String compiledProgram = assembler.assemble();

        /* Write the compiled program to an output file */
        try {
            PrintWriter writer = new PrintWriter("./output/" + program.getName() + ".j", "UTF-8");
            writer.write(compiledProgram);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found or could not be created.");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unable to encode data.");
        }

        /* Produce bytecode using JASMIN */
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "jasmin.jar", program.getName() + ".j");
        processBuilder.directory(new File("output/"));

        try {
            Process jasmin = processBuilder.start();
            jasmin.waitFor();
        } catch (Exception e) {
            System.out.println("Failed to assemble the JASMIN file.");
        }

        /* Run the produced java program and retrieve the output */
        processBuilder = new ProcessBuilder("java", program.getName());
        processBuilder.directory(new File("output/"));

        String outcome = "";

        try {
            Process programRunner = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(programRunner.getInputStream()));
            outcome = reader.readLine();
        } catch (IOException e) {
            System.out.println("Unable to read the program's output.");
        }

        return outcome;
    }
}