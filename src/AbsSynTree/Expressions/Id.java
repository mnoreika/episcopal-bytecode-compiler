package AbsSynTree.Expressions;

import AbsSynTree.Expression;
import java.util.HashMap;

public class Id extends Expression {
    private String name;

    public Id (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String compile(HashMap<String, Expression> scope) {
        String result = "";

        if (scope.containsKey(name)) {
            result += scope.get(name).compile(scope);
        }

        return result;
    }
}
