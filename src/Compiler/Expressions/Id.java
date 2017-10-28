package Compiler.Expressions;

import Compiler.Expression;
import Compiler.Compilable;
import java.util.HashMap;
import Compiler.Assembler;

public class Id extends Expression {
    private String name;

    public Id (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        if (scope.containsKey(name)) {
            scope.get(name).compile(scope, assembler);
        }
    }
}
