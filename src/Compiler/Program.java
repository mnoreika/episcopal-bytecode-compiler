package Compiler;

import Compiler.Definitions.FunctionDef;
import Compiler.Expressions.Id;

import java.util.HashMap;

import static Compiler.Instruction.*;

public class Program {
    private Id id;
    private Expression expr;
    private FunctionDef[] queries;

    public Program(Id id, Expression expr) {
        this.id = id;
        this.expr = expr;
        this.queries = null;
    }

    public Program(Id id, Expression expr, FunctionDef[] queries) {
        this.id = id;
        this.expr = expr;
        this.queries = queries;
    }

    public void compile(Assembler assembler) {
        HashMap<String, Compilable> scope = new HashMap<>();

        assembler.addInstruction(CLASS, id.getName());
        assembler.addInstruction(SUPER);
        assembler.addInstruction(INITMETHOD);
        assembler.addInstruction(MAINMETHOD);

        expr.compile(scope, assembler);

        if (queries != null) {
            for (FunctionDef query : queries) {
                query.compile(scope, assembler);
            }
        }

        assembler.addInstruction(PRINT);
        assembler.addInstruction(RETURN);
        assembler.addInstruction(ENDMETHOD);
    }

    public String getName() {
        return id.getName();
    }
}
