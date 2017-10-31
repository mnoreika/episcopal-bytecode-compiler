package Compiler.Distributions;

import Compiler.Distribution;
import Compiler.Compilable;
import Compiler.Assembler;
import java.util.HashMap;

import static Compiler.Instruction.BETA;
import static Compiler.Instruction.LDC;

public class Beta extends Distribution {
    private int a;
    private int b;

    public Beta(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(LDC, a);
        assembler.addInstruction(LDC, b);
        assembler.addInstruction(BETA);
    }
}
