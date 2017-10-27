package Compiler.Constants;

import Compiler.Constant;
import Compiler.Expression;
import java.util.HashMap;
import Compiler.Compilable;

import static Compiler.Instruction.LDC;
import static Compiler.Instruction.NLINE;



public class Integer extends Constant {
    private String value;

    public Integer(String value) {
        this.value = value;
    }

    @Override
    public String compile(HashMap<String, Compilable> scope) {
        return LDC + value + NLINE;
    }
}
