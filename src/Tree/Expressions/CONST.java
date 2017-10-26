package Tree.Expressions;

import Tree.Expression;

public class CONST extends Expression {
    private int value;

    public CONST (int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
