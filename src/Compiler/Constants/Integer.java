package Compiler.Constants;

import Compiler.Constant;

import java.util.HashMap;
import Compiler.Compilable;
import Compiler.Assembler;

import static Compiler.Instruction.*;


public class Integer extends Constant {
    private String value;

    public Integer(String value) {
        this.value = value;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(NEWVAR);
        assembler.addInstruction(DUP);
        assembler.addInstruction(LDC, value);
        assembler.addInvokeInstruction(TYPEINT);
    }
}
