package AbsSynTree.Expressions;

import AbsSynTree.Definition;
import AbsSynTree.Expression;

public class Let {
    private Definition defn;
    private Expression expr;

    public Let(Definition defn, Expression expr) {
        this.defn = defn;
        this.expr = expr;
    }
}
