package Compiler.Expressions;

import Compiler.Expression;
import Compiler.Compilable;
import java.util.HashMap;

import static Compiler.Instruction.INVSTATIC;
import static Compiler.Instruction.NLINE;

public class FunctionCall extends Expression {
    private Id id;
    private Expression[] args;

    public FunctionCall (Id id, Expression[] args) {
        this.id = id;
        this.args = args;
    }

    @Override
    public String compile(HashMap<String, Compilable> scope) {
        String result = "";

        for (Expression arg : args) {
            result += arg.compile(scope);
        }

        result += INVSTATIC + "path" + NLINE;

        return result;
    }


}
