package Compiler.Distributions;

import Compiler.Constants.Float;
import Compiler.Distribution;
import Compiler.Compilable;
import Compiler.Assembler;
import java.util.HashMap;

import static Compiler.Instruction.BERNOULLI;
import static Compiler.Instruction.LDC;

public class Bernoulli extends Distribution {
    private Float p;

    public Bernoulli(Float p) {
        this.p = p;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        p.compile(scope, assembler);
        assembler.addInstruction(BERNOULLI);
    }
}
