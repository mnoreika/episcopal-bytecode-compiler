package Compiler;

import Compiler.Expressions.Id;
import java.util.HashMap;

import static Compiler.Instruction.ILOAD;

public class FunctionArg extends Expression {
    private Id argument;
    private int position;

    public FunctionArg(int position, Id argument) {
        this.argument = argument;
        this.position = position;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(ILOAD, position);
    }
}
