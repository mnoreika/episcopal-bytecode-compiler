package Compiler;

import java.util.HashMap;

public interface Compilable {
    public abstract String compile(HashMap<String, Compilable> scope);
}
