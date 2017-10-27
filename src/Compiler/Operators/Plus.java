package Compiler.Operators;

import Compiler.Operator;

import static Compiler.Instruction.NLINE;
import static Compiler.Instruction.PLUS;

public class Plus extends Operator {

    @Override
    public String compile() {
        return PLUS.toString() + NLINE;
    }
}
