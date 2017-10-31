package Compiler;

import java.util.ArrayList;

public class Assembler {
    private ArrayList<Object> instructions;
    private ArrayList<Assembler> functions;

    public Assembler() {
        instructions = new ArrayList<>();
        functions = new ArrayList<>();
    }

    public String assemble() {
        StringBuilder result = new StringBuilder();

        for (Object inst : instructions) {
            result.append(inst);
            result.append("\n");
        }

        result.append("\n");

        for (Assembler func : functions) {
            ArrayList<Object> funcInstructions = func.getIntructions();

            for (Object inst : funcInstructions) {
                result.append(inst);
                result.append("\n");
            }
            result.append("\n");
        }

        return result.toString();
    }

    public void addInstruction(Object inst) {
        instructions.add(inst);
    }

    public void addInstruction(Object inst1, Object inst2) {
        instructions.add(inst1 + " " + inst2);
    }

    public void addFunction(Assembler function) {

        functions.add(function);
    }

    public ArrayList<Object> getIntructions() {
        return instructions;
    }

}
