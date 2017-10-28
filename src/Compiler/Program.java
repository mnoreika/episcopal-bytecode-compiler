package Compiler;

import Compiler.Expressions.Id;

import java.util.HashMap;

import static Compiler.Instruction.*;

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

    public void compile(Assembler assembler) {
        HashMap<String, Compilable> scope = new HashMap<>();

        assembler.addInstruction(".class public " + id.getName());
        assembler.addInstruction(".super java/lang/Object");
        assembler.addInstruction(INITMETHOD);
        assembler.addInstruction(MAINMETHOD);

        expr.compile(scope, assembler);

        assembler.addInstruction("invokestatic java/lang/String/valueOf(I)Ljava/lang/String;");
        assembler.addInstruction("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
        assembler.addInstruction(RETURN);
        assembler.addInstruction(ENDMETHOD);
    }
}
