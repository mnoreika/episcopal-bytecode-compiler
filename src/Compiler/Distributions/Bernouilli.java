package Compiler.Distributions;

import Compiler.Expressions.Distribution;
import Compiler.Expression;
import Compiler.Compilable;
import Compiler.Assembler;
import java.util.HashMap;

import static Compiler.Instruction.*;

public class Bernouilli extends Distribution {
    private Expression p;

    public Bernouilli(Expression p) {
        this.p = p;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(NEWVAR);
        assembler.addInstruction(DUP);
        assembler.addInstruction(NEWBERNOUILLI);
        assembler.addInstruction(DUP);
        p.compile(scope, assembler);
        assembler.addInstruction(INITBERNOUILLI);
        assembler.addInstruction(INITDISTR);
    }
}
