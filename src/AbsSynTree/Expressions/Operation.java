package AbsSynTree.Expressions;

import AbsSynTree.Expression;
import AbsSynTree.Operator;

public class Operation {
    private Operator op;
    private Expression left;
    private Expression right;

    public Operation(Operator op, Expression left, Expression right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }
}
