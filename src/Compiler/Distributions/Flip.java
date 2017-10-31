package Compiler.Distributions;

import Compiler.Distribution;
import Compiler.Compilable;
import Compiler.Assembler;
import java.util.HashMap;

import static Compiler.Instruction.FLIP;
import static Compiler.Instruction.LDC;

public class Flip extends Distribution {
    private float p;

    public Flip(float p) {
        this.p = p;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(LDC, p);
        assembler.addInstruction(FLIP);
    }
}
