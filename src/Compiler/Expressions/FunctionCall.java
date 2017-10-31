package Compiler.Expressions;

import Compiler.Expression;
import Compiler.Compilable;
import Compiler.Assembler;
import java.util.HashMap;

import static Compiler.Instruction.INVSTATIC;

public class FunctionCall extends Expression {
    private Id id;
    private Expression[] args;

    public FunctionCall (Id id) {
        this.id = id;
    }

    public FunctionCall (Id id, Expression[] args) {
        this.id = id;
        this.args = args;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        if (args != null) {
            for (Expression arg : args) {
                arg.compile(scope, assembler);
            }
        }

        assembler.addInstruction(INVSTATIC + "Function/" + id.getName() + "(II)I");
    }


}
