package Tree.Statements;

import Tree.Expression;
import Tree.Statement;

public class MOVE extends Statement {
    private Expression dst;
    private Expression src;

    public MOVE (Expression dst, Expression src) {
        this.dst = dst;
        this.src = src;
    }
}
