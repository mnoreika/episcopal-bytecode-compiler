package Compiler.Operators;

import Compiler.Operator;
import Compiler.Assembler;

import static Compiler.Instruction.PLUS;

public class Plus extends Operator {

    @Override
    public void compile(Assembler assembler) {
        assembler.addInstruction(PLUS);
    }
}
