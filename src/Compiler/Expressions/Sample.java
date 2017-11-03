package Compiler.Expressions;

import Compiler.Expression;
import Compiler.Compilable;
import Compiler.Assembler;
import java.util.HashMap;

import static Compiler.Instruction.SAMPLE;

public class Sample extends Expression {
    private Expression expr;

    public Sample(Expression expr) {
        this.expr = expr;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        expr.compile(scope, assembler);
        assembler.addInstruction(SAMPLE);
    }
}
