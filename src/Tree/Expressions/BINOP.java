package Tree.Expressions;

import Tree.Expression;
import Tree.Operation;

public class BINOP extends Expression {
    private Operation op;
    private Expression left;
    private Expression right;

    public BINOP (Operation op, Expression left, Expression right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }
}
