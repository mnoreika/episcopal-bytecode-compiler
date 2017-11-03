package Compiler.Expressions;

import Compiler.Expression;
import Compiler.Compilable;
import Compiler.Assembler;
import java.util.HashMap;

import static Compiler.Instruction.ALOAD;

public class FunctionArg extends Expression {
    private int position;

    public FunctionArg(int position) {
        this.position = position;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(ALOAD, position);
    }
}
