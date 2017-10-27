package Compiler;

import Compiler.Expressions.Id;

import java.util.HashMap;

public class Program {
    private Id id;
    private Expression expr;
    private Query query;

    public Program(Id id, Expression expr) {
        this.id = id;
        this.expr = expr;
        this.query = null;
    }

    public Program(Id id, Expression expr, Query query) {
        this.id = id;
        this.expr = expr;
        this.query = query;
    }

    public String compile() {
        String result = "";

        result += ".class public " + id.getName() + "\n" +
                ".super java/lang/Object\n" +
                "\n" +
                ".method public <init>()V\n" +
                "   aload_0\n" +
                "   invokespecial java/lang/Object/<init>()V\n" +
                "   return\n" +
                ".end method\n" +
                "\n" +
                ".method public static main([Ljava/lang/String;)V\n" +
                ".limit stack 20\n" +
                ".limit locals 20\n" +
                "getstatic java/lang/System/out Ljava/io/PrintStream;\n";

        HashMap<String, Compilable> scope = new HashMap<>();

        result += expr.compile(scope);

        result += "\ninvokestatic java/lang/String/valueOf(I)Ljava/lang/String;\n";
        result += "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n";

        result += "return\n";
        result += ".end method";

        return result;
    }
}
