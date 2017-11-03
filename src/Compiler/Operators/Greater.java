package Compiler.Operators;

import Compiler.Operator;
import Compiler.Assembler;

import static Compiler.Instruction.GREATER;

public class Greater extends Operator {

    @Override
    public void compile(Assembler assembler) {
        assembler.addInstruction(GREATER);
    }
}
