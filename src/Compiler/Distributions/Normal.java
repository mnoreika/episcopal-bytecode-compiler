package Compiler.Distributions;

import Compiler.Constants.Float;
import Compiler.Expressions.Distribution;
import Compiler.Compilable;
import Compiler.Assembler;

import java.util.HashMap;

import static Compiler.Instruction.*;

public class Normal extends Distribution {
    private Float mean;
    private Float std;

    public Normal(Float mean, Float std) {
        this.mean = mean;
        this.std = std;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(NEWVAR);
        assembler.addInstruction(DUP);
        assembler.addInstruction(NEWNORMAL);
        assembler.addInstruction(DUP);
        mean.compile(scope, assembler);
        std.compile(scope, assembler);
        assembler.addInstruction(INITNORMAL);
        assembler.addInstruction(INITDISTR);
    }
}
