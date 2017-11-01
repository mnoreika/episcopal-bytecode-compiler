package Compiler;

import java.util.ArrayList;

import static Compiler.Instruction.INVOKE;
import static Compiler.Instruction.INVSTATIC;
import static Compiler.Instruction.TYPEVARIABLE;

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

    public void addInvokeInstruction(Instruction type) {
        addInstruction(INVOKE + "(" + type + ")V");

    }

    public void addFunction(Assembler function) {
        functions.add(function);
    }

    public void addFunctionSignature(String functionName, int numberOfArguments) {
        StringBuilder arguments = new StringBuilder();

        for (int i = 0; i < numberOfArguments; i++) {
            arguments.append(TYPEVARIABLE);
        }

        addInstruction(".method public static " + functionName + "(" + arguments + ")" + TYPEVARIABLE);
    }

    public void addFunctionCall(String functionName, int numberOfArguments) {
        StringBuilder arguments = new StringBuilder();

        for (int i = 0; i < numberOfArguments; i++) {
            arguments.append(TYPEVARIABLE);
        }

        addInstruction(INVSTATIC + functionName + "(" + arguments + ")" + TYPEVARIABLE);
    }

    public ArrayList<Object> getIntructions() {
        return instructions;
    }


}
