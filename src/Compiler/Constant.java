package Compiler;

import java.util.HashMap;

public abstract class Constant extends Expression {
    public abstract String compile(HashMap<String, Compilable> scope);
}
