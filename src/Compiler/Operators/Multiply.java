package Compiler.Operators;

import Compiler.Operator;

import static Compiler.Instruction.NLINE;
import static Compiler.Instruction.MULT;

public class Multiply extends Operator {

    @Override
    public String compile() {
        return MULT.toString() + NLINE;
    }
}
