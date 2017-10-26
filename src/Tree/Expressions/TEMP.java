package Tree.Expressions;

import Tree.Expression;

public class TEMP extends Expression {
    private String temp;

    public TEMP (String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return temp;
    }
}
