package Compiler.Constants;

import Compiler.Constant;
import Compiler.Compilable;
import Compiler.Assembler;

import java.util.HashMap;

public class Float extends Constant {
    private float value;

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
    }
}
