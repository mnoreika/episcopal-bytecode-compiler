package Compiler;

public enum Instruction {
    INITMETHOD(".method public <init>()V\n" +
                "   aload_0\n" +
                "   invokespecial java/lang/Object/<init>()V\n" +
                "   return\n" +
                ".end method"),
    MAINMETHOD(".method public static main([Ljava/lang/String;)V\n" +
                ".limit stack 20\n" +
                ".limit locals 20\n" +
                "getstatic java/lang/System/out Ljava/io/PrintStream;"),
    INVSTATIC("invokestatic "),
    ENDMETHOD(".end method"),
    RETURN("return"),
    LDC("ldc"),
    PLUS("iadd"),
    MULT("imul"),
    ILOAD("iload"),
    IRETURN("ireturn");

    private String value;

    Instruction(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
