package Compiler.Expressions;

import Compiler.Definition;
import Compiler.Expression;
import Compiler.Compilable;
import Compiler.Assembler;

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
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        defn.compile(scope, assembler);
        expr.compile(scope, assembler);
    }
}
