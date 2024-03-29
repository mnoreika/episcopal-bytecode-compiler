package Compiler.Definitions;

import Compiler.Definition;
import Compiler.Expression;
import Compiler.Expressions.Id;
import Compiler.Compilable;
import Compiler.Assembler;


import java.util.HashMap;

import static Compiler.Instruction.*;

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

            function.addFunctionSignature(id.getName(), args.length);
            function.addInstruction(STACKLIMIT);
            function.addInstruction(LOCALSLIMIT);

            for (Expression expr : exprs) {
                expr.compile(scope, function);
            }

            function.addInstruction(ARETURN);
            function.addInstruction(ENDMETHOD);

            assembler.addFunction(function);
        }
    }
}
