package Compiler.Operators;

import Compiler.Operator;
import Compiler.Assembler;

import static Compiler.Instruction.LESS;

public class Less extends Operator {

    @Override
    public void compile(Assembler assembler) {
        assembler.addInstruction(LESS);
    }
}
