package AbsSynTree;

import AbsSynTree.Expressions.Id;

public class Program {
    private Id id;
    private Expression expr;
    private Query query;

    public Program(Id id, Expression expr) {
        this.id = id;
        this.expr = expr;
        this.query = null;
    }

    public Program(Id id, Expression expr, Query query) {
        this.id = id;
        this.expr = expr;
        this.query = query;
    }
}
