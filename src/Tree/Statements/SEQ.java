package Tree.Statements;

import Tree.Statement;

public class SEQ {
    private Statement left;
    private Statement right;

    public SEQ (Statement left, Statement right) {
        this.left = left;
        this.right = right;
    }
}
