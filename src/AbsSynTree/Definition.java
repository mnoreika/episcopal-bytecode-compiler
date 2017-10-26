package AbsSynTree;

import java.util.HashMap;

public abstract class Definition {

    public abstract String compile(HashMap<String, Expression> scope);
}

