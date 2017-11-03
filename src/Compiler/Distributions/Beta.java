package Compiler.Distributions;

import Compiler.Constants.Float;
import Compiler.Expressions.Distribution;
import Compiler.Compilable;
import Compiler.Assembler;
import java.util.HashMap;

import static Compiler.Instruction.*;

public class Beta extends Distribution {
    private Float a;
    private Float b;

    public Beta(Float a, Float b) {
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
