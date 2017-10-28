package Compiler.Definitions;

import Compiler.Definition;
import Compiler.Expression;
import Compiler.Expressions.Id;
import Compiler.Compilable;
import Compiler.Assembler;

import static Compiler.Instruction.ENDMETHOD;
import static Compiler.Instruction.IRETURN;


import java.util.HashMap;

public class FunctionDef extends Definition {
    private Id id;
    private Id[] args;
    private Expression[] exprs;

    public FunctionDef(Id id, Expression[] expr) {
        this.id = id;
        this.args = null;
        this.exprs = expr;
    }

    public FunctionDef(Id id, Id[] args, Expression[] expr) {
        this.id = id;
        this.args = args;
        this.exprs = expr;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        if (args == null) {
            scope.put(id.getName(), exprs[0]);
        } else {
            Assembler function = new Assembler();

            function.addInstruction(".method public static " + id.getName() + "(II)I");

            for (Expression expr : exprs) {
                expr.compile(scope, function);
            }

            function.addInstruction(IRETURN);
            function.addInstruction(ENDMETHOD);

            assembler.addFunction(function);
        }
    }
}
