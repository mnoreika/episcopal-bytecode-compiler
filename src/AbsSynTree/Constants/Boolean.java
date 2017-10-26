package AbsSynTree.Constants;

import AbsSynTree.Constant;
import AbsSynTree.Expression;

import java.util.HashMap;

public class Boolean extends Constant {
    private boolean value;

    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public String compile(HashMap<String, Expression> scope) {
        return null;
    }
}
