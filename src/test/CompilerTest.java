import Compiler.Constants.Boolean;
import Compiler.Constants.Integer;
import Compiler.Constants.Float;
import Compiler.Definitions.FunctionDef;
import Compiler.Distributions.Bernoulli;
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





    private void assertCompilation(Program program, String expectedOutcome) throws InterruptedException {
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
        } catch (IOException e) {
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

        /* Assert if the outcome is as expected */
        assertEquals(expectedOutcome, outcome);

    }
}