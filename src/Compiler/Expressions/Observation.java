package Compiler.Expressions;

import Compiler.Expression;
import Compiler.Compilable;
import Compiler.Assembler;
import java.util.HashMap;

import static Compiler.Instruction.*;

public class Observation extends Expression {
    private Operation statement;
    private Expression expr;

    public Observation(Operation statement, Expression expr) {
        this.statement = statement;
        this.expr = expr;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        statement.compile(scope, assembler);
        assembler.addInstruction(BOOLTOINT);
        assembler.addInstruction(IFTRUE);
        expr.compile(scope, assembler);
        assembler.addInstruction(FAILLABEL);
        assembler.addInstruction(MAKEFAILOBJECT);
    }
}
