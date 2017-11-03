package Compiler.Distributions;

import Compiler.Constants.Float;
import Compiler.Expressions.Distribution;
import Compiler.Compilable;
import Compiler.Assembler;
import java.util.HashMap;

import static Compiler.Instruction.*;

public class Bernouilli extends Distribution {
    private Float p;

    public Bernouilli(Float p) {
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
