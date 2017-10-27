package Compiler;

import Compiler.Definitions.FunctionDef;
import Compiler.Expressions.Id;
import java.util.HashMap;

import static Compiler.Instruction.ILOAD;

public class FunctionArg extends Expression {
    private Id function;
    private Id argument;

    public FunctionArg(Id function, Id argument) {
        this.function = function;
        this.argument = argument;
    }

    @Override
    public String compile(HashMap<String, Compilable> scope) {
        FunctionDef def = (FunctionDef) scope.get(function.getName());
        int stackIndex = def.findArgumentIndex(argument);

        return ILOAD.toString() + stackIndex;
    }
}
