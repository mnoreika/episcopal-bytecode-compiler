package Compiler.Distributions;

import Compiler.Distribution;
import Compiler.Compilable;
import Compiler.Assembler;
import java.util.HashMap;

import static Compiler.Instruction.BERNOULLI;
import static Compiler.Instruction.LDC;

public class Bernoulli extends Distribution {
    private float p;

    public Bernoulli(float p) {
        this.p = p;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(LDC, p);
        assembler.addInstruction(BERNOULLI);
    }
}
