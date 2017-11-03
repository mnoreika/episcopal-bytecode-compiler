package Compiler.Operators;

import Compiler.Assembler;
import Compiler.Operator;

import static Compiler.Instruction.AND;

public class And extends Operator {

    @Override
    public void compile(Assembler assembler) {
        assembler.addInstruction(AND);
    }
}
