package Compiler.Expressions;

import Compiler.Expression;
import Compiler.Operator;
import Compiler.Compilable;
import Compiler.Assembler;

import java.util.HashMap;

public class Operation extends Expression {
    private Operator op;
    private Expression left;
    private Expression right;

    public Operation(Operator op, Expression left, Expression right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public Operator getOp() {
        return op;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        left.compile(scope, assembler);
        right.compile(scope, assembler);
        op.compile(assembler);
    }
}
