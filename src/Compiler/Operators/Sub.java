package Compiler.Operators;

import Compiler.Operator;
import Compiler.Assembler;

import static Compiler.Instruction.SUB;

public class Sub extends Operator {

    @Override
    public void compile(Assembler assembler) {
        assembler.addInstruction(SUB);
    }
}
