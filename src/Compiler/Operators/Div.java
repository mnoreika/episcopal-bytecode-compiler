package Compiler.Operators;

import Compiler.Operator;
import Compiler.Assembler;

import static Compiler.Instruction.DIV;

public class Div extends Operator {

    @Override
    public void compile(Assembler assembler) {
        assembler.addInstruction(DIV);
    }
}
