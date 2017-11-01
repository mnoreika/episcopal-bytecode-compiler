package Compiler.Constants;

import Compiler.Constant;
import Compiler.Compilable;
import Compiler.Assembler;

import java.util.HashMap;

import static Compiler.Instruction.LDC;

public class Float extends Constant {
    private String value;

    public Float(String value) {
        this.value = value;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(LDC, value);
    }
}
