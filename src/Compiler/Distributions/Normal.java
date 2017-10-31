package Compiler.Distributions;

import Compiler.Distribution;
import Compiler.Compilable;
import Compiler.Assembler;

import java.util.HashMap;

import static Compiler.Instruction.LDC;
import static Compiler.Instruction.NORMAL;

public class Normal extends Distribution {
    private float mean;
    private float std;

    public Normal(float mean, float std) {
        this.mean = mean;
        this.std = std;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(LDC, mean);
        assembler.addInstruction(LDC, std);
        assembler.addInstruction(NORMAL);
    }
}
