package AbsSynTree.Constants;

import AbsSynTree.Constant;
import AbsSynTree.Expression;

import java.util.HashMap;

public class Integer extends Constant {
    private int value;

    public Integer(int value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public String compile(HashMap<String, Expression> scope) {
        return "ldc " + value + "\n";
    }
}
