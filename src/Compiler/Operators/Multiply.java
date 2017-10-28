package Compiler.Operators;

import Compiler.Operator;
import Compiler.Assembler;

import static Compiler.Instruction.MULT;


public class Multiply extends Operator {

    @Override
    public void compile(Assembler assembler) {
        assembler.addInstruction(MULT);
    }
}
