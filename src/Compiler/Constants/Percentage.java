package Compiler.Constants;

import Compiler.Constant;
import Compiler.Compilable;
import Compiler.Assembler;

import java.util.HashMap;

import static Compiler.Instruction.LDC;


public class Percentage extends Constant {
    private int value;

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(LDC, value);
    }
}
