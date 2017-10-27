package Compiler.Constants;

import Compiler.Constant;
import Compiler.Expression;
import Compiler.Compilable;

import java.util.HashMap;

public class Percentage extends Constant {
    private int value;

    @Override
    public String compile(HashMap<String, Compilable> scope) {
        return "ldc " + value + "\n";
    }
}
