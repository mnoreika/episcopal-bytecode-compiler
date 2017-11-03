package Compiler.Distributions;

import Compiler.Expressions.Distribution;
import Compiler.Compilable;
import Compiler.Assembler;
import Compiler.Expression;
import java.util.HashMap;

import static Compiler.Instruction.*;

public class Beta extends Distribution {
    private Expression a;
    private Expression b;

    public Beta(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(NEWVAR);
        assembler.addInstruction(DUP);
        assembler.addInstruction(NEWBETA);
        assembler.addInstruction(DUP);
        a.compile(scope, assembler);
        b.compile(scope, assembler);
        assembler.addInstruction(INITBETA);
        assembler.addInstruction(INITDISTR);
    }
}
