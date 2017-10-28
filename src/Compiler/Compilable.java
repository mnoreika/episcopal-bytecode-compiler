package Compiler;

import java.util.HashMap;

public interface Compilable {
    public abstract void compile(HashMap<String, Compilable> scope, Assembler assembler);
}
