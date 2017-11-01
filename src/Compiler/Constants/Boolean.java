package Compiler.Constants;

import Compiler.Constant;
import Compiler.Compilable;
import Compiler.Assembler;

import java.util.HashMap;

import static Compiler.Instruction.*;

public class Boolean extends Constant {
    private String value;

    public Boolean (String value) {
        this.value = value;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(NEWVAR);
        assembler.addInstruction(DUP);
        assembler.addInstruction(LDC, value);
        assembler.addInvokeInstruction(TYPEBOOLEAN);
    }
}
