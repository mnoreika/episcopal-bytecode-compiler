package Tree.Expressions;

import Tree.Expression;

import java.util.ArrayList;

public class CALL {
    private Expression function;
    private ArrayList<Expression> arguments;

    public CALL (Expression function, ArrayList<Expression> arguments) {
        this.function = function;
        this.arguments = arguments;
    }
}
