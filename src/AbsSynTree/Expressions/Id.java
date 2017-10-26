package AbsSynTree.Expressions;

import AbsSynTree.Expression;

public class Id extends Expression {
    private String name;

    public Id (String name) {
        this.name = name;
    }
}
