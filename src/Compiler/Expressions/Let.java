package Compiler.Expressions;

import Compiler.Definition;
import Compiler.Expression;
import Compiler.Compilable;

import java.util.HashMap;

public class Let extends Expression {
    private Definition defn;
    private Expression expr;

    public Let(Definition defn, Expression expr) {
        this.defn = defn;
        this.expr = expr;
    }

    public Definition getDefn() {
        return defn;
    }

    public Expression getExpr() {
        return expr;
    }

    @Override
    public String compile(HashMap<String, Compilable> scope) {
        return defn.compile(scope) + expr.compile(scope);
    }
}
