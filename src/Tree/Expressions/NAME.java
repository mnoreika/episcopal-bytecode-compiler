package Tree.Expressions;

import Tree.Expression;

public class NAME extends Expression {
    private String name;

    public NAME (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
