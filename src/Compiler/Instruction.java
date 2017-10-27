package Compiler;

public enum Instruction {
    NLINE("\n"),
    INVSTATIC("invokestatic "),
    LDC("ldc "),
    PLUS("iadd"),
    MULT("imul"),
    ILOAD("iload ");

    private String value;

    Instruction(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
