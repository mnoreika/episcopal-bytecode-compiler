import Compiler.Constants.Integer;
import Compiler.Definitions.FunctionDef;
import Compiler.Expression;
import Compiler.Expressions.FunctionCall;
import Compiler.Expressions.Id;
import Compiler.Expressions.Let;
import Compiler.Expressions.Operation;
import Compiler.Operators.Multiply;
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
    public void addition() throws Exception {
       Program addition = new Program(new Id("Addition"),
                new Let(new FunctionDef(new Id("x"), new Expression[] {new Integer("1")}),
                        new Let(new FunctionDef(new Id("y"), new Expression[] {new Integer("41")}),
                                new Let(new FunctionDef(new Id("sum"), new Expression[] {
                                        new Operation(new Plus(), new Id("x"), new Id("y"))}),
                                        new Id("sum")))));

       assertCompilation(addition, "42");
    }

    @Test
    public void function() throws Exception {
        Program function = new Program(new Id("Function"),
                new Let(new FunctionDef(new Id ("funcA"), new Id[] {new Id("x"), new Id("y")}, new Expression[] {
                        new Operation(new Plus(), new FunctionArg(0, new Id("x")),
                                new Operation(new Multiply(), new FunctionArg(0, new Id("x")), new FunctionArg(1, new Id("y"))))
                }),
                        new FunctionCall(new Id("funcA"), new Expression[] {new Integer("7"), new Integer("5")})));

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