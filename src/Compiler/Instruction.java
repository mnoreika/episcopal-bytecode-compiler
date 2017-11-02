package Compiler;

public enum Instruction {
    INITMETHOD(".method public <init>()V\n" +
                "   aload_0\n" +
                "   invokespecial java/lang/Object/<init>()V\n" +
                "   return\n" +
                ".end method"),
    MAINMETHOD(".method public static main([Ljava/lang/String;)V\n" +
                ".limit stack 20\n" +
                ".limit locals 20\n"),
    INVSTATIC("invokestatic "),
    ENDMETHOD(".end method"),
    RETURN("return"),
    LDC("ldc"),
    PLUS("invokestatic Operations/add(LVariable;LVariable;)LVariable;"),
    EQUALS("invokestatic Operations/equals(LVariable;LVariable;)LVariable;"),
    MULT("imul"),
    ALOAD("aload"),
    ARETURN("areturn"),
    DUP("dup"),
    NEWVAR("new Variable"),
    INVOKE("invokespecial Variable/<init>"),
    BERNOULLI("invokestatic Distributions/Bernoulli(LVariable;)LVariable;"),
    BETA("invokestatic Distributions/Beta(LVariable;LVariable;)LVariable;"),
    FLIP("invokestatic Distributions/Flip(LVariable;)LVariable;"),
    NORMAL("invokestatic Distributions/Normal(LVariable;LVariable;)LVariable;"),
    BOOLTOINT("invokestatic Operations/boolToInt(LVariable;)I"),
    IFTRUE("ifeq Fail"),
    FAILLABEL("Fail:"),
    MAKEFAILOBJECT("invokestatic Operations/makeFailObject()LVariable;"),
    TYPEINT("I"),
    TYPEFLOAT("F"),
    TYPEBOOLEAN("Z"),
    TYPEVARIABLE("LVariable;");

    private String value;

    Instruction(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
