import Compiler.Program;
import Compiler.Assembler;
import java.io.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tester {

    public Tester() {}

    void assertCompilationInRange(Program program, Assembler assembler, int rangeStart, int rangeEnd) {
        String outcome = compileAndRunProgram(program, assembler);
        java.lang.Float result = java.lang.Float.valueOf(outcome);

        assertTrue(result >= rangeStart);
        assertTrue(result <= rangeEnd);
    }

    void assertVariedCompilation(Program program, Assembler assembler, String[] possibleOutcomes) {
        String outcome = compileAndRunProgram(program, assembler);

        boolean matchFound = false;

        for (int i = 0; i < possibleOutcomes.length; i++) {
            if (outcome.equals(possibleOutcomes[i])) {
                matchFound = true;
            }
        }

        assertTrue(matchFound);
    }

    void assertCompilation(Program program, Assembler assembler, String expectedOutcome) {
        String outcome = compileAndRunProgram(program, assembler);

        /* Assert if the outcome is as expected */
        assertEquals(expectedOutcome, outcome);
    }

    private String compileAndRunProgram(Program program, Assembler assembler) {
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