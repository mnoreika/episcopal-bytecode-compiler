package Compiler.Distributions;

import Compiler.Constants.Float;
import Compiler.Distribution;
import Compiler.Compilable;
import Compiler.Assembler;
import java.util.HashMap;

import static Compiler.Instruction.BETA;
import static Compiler.Instruction.LDC;

public class Beta extends Distribution {
    private Float a;
    private Float b;

    public Beta(Float a, Float b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        a.compile(scope, assembler);
        b.compile(scope, assembler);
        assembler.addInstruction(BETA);
    }
}
