package Compiler.Distributions;

import Compiler.Expressions.Distribution;
import Compiler.Expression;
import Compiler.Compilable;
import Compiler.Assembler;
import java.util.HashMap;

import static Compiler.Instruction.*;

public class Flip extends Distribution {
    private Expression p;

    public Flip(Expression p) {
        this.p = p;
    }

    @Override
    public void compile(HashMap<String, Compilable> scope, Assembler assembler) {
        assembler.addInstruction(NEWVAR);
        assembler.addInstruction(DUP);
        assembler.addInstruction(NEWFLIP);
        assembler.addInstruction(DUP);
        p.compile(scope, assembler);
        assembler.addInstruction(INITFLIP);
        assembler.addInstruction(INITDISTR);
    }
}
