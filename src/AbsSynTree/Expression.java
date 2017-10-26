package AbsSynTree;

import java.util.HashMap;

public abstract class Expression {
    public abstract String compile(HashMap<String, Expression> scope);
}
