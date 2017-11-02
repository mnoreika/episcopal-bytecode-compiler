package Compiler.Distributions;

import Compiler.Constants.Float;
import Compiler.Distribution;
import Compiler.Compilable;
import Compiler.Assembler;

import java.util.HashMap;

import static Compiler.Instruction.LDC;
import static Compiler.Instruction.NORMAL;

public class Normal extends Distribution {
    private Float mean;
    private Float std;

    public Normal(Float mean, Float std) {
        this.mean = mean;
        this.std = std;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        mean.compile(scope, assembler);
        std.compile(scope, assembler);
        assembler.addInstruction(NORMAL);
    }
}
