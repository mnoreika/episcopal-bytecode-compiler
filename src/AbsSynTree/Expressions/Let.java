package AbsSynTree.Expressions;

import AbsSynTree.Definition;
import AbsSynTree.Expression;

import java.util.HashMap;

public class Let extends Expression {
    private Definition defn;
    private Expression expr;

    public Let(Definition defn, Expression expr) {
        this.defn = defn;
        this.expr = expr;
    }

    public Definition getDefn() {
        return defn;
    }

    public Expression getExpr() {
        return expr;
    }

    @Override
    public String compile(HashMap<String, Expression> scope) {
        return defn.compile(scope) + expr.compile(scope);
    }
}
