package Tree.Statements;

import Tree.Expression;
import Tree.Statement;

public class EXP extends Statement {
    private Expression exp;

    public EXP (Expression exp) {
        this.exp = exp;
    }
}
