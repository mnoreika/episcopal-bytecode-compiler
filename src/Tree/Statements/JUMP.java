package Tree.Statements;

import Tree.Expression;

import java.util.ArrayList;

public class JUMP {
    Expression exp;
    ArrayList<LABEL> targets;

    public JUMP (Expression exp, ArrayList<LABEL> targets) {
        this.exp = exp;
        this.targets = targets;
    }
}
