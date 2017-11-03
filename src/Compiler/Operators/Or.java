package Compiler.Operators;

import Compiler.Assembler;
import Compiler.Operator;

import static Compiler.Instruction.OR;

public class Or extends Operator {

    @Override
    public void compile(Assembler assembler) {
        assembler.addInstruction(OR);
    }
}
