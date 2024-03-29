package Compiler;

import java.util.HashMap;

public abstract class Constant extends Expression {
    public abstract void compile(HashMap<String, Compilable> scope, Assembler assembler);
}
