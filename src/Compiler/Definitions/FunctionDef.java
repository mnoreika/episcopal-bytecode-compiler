package Compiler.Definitions;

import Compiler.Definition;
import Compiler.Expression;
import Compiler.Expressions.Id;
import Compiler.Compilable;


import java.util.HashMap;

public class FunctionDef extends Definition {
    private Id id;
    private Id[] args;
    private Expression[] expr;

    public FunctionDef(Id id, Expression[] expr) {
        this.id = id;
        this.args = null;
        this.expr = expr;
    }

    public FunctionDef(Id id, Id[] args, Expression[] expr) {
        this.id = id;
        this.args = args;
        this.expr = expr;
    }

    public int findArgumentIndex(Id arg) {
        int index = 0;

        for (int i = 0; i < args.length; i++) {
            if (args[i].getName().equals(arg.getName())) {
                index = i;
            }
        }

        return index;
    }

    @Override
    public String compile(HashMap<String, Compilable> scope) {
        String result = "";

        if (args == null) {
            scope.put(id.getName(), expr[0]);
        } else {
            result += ".method public static " + id.getName() + "(II)I \n";

            for (Id arg : args) {
                result += arg.compile(scope);
            }

            scope.put(id.getName(), this);
        }

        return result;
    }
}
