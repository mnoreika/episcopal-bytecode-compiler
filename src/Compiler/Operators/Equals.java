package Compiler.Operators;

import Compiler.Operator;
import Compiler.Assembler;

import static Compiler.Instruction.EQUALS;

public class Equals extends Operator {

    @Override
    public void compile(Assembler assembler) {
        assembler.addInstruction(EQUALS);
    }
}
