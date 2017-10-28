package Compiler.Constants;

import Compiler.Constant;
import Compiler.Compilable;
import Compiler.Assembler;

import java.util.HashMap;

public class Boolean extends Constant {
    private boolean value;

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
    }
}
