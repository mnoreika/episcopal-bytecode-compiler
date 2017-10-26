package AbsSynTree.Definitions;

import AbsSynTree.Arguments;
import AbsSynTree.Definition;
import AbsSynTree.Expression;
import AbsSynTree.Expressions.Id;

public class FunctionDef extends Definition {
    private Id id;
    private Arguments args;
    private Expression[] expr;

    public FunctionDef(Id id, Expression[] expr) {
        this.id = id;
        this.args = null;
        this.expr = expr;
    }

    public FunctionDef(Id id, Arguments args, Expression[] expr) {
        this.id = id;
        this.args = args;
        this.expr = expr;
    }
}
