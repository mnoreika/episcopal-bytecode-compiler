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
    MULT("invokestatic Operations/mult(LVariable;LVariable;)LVariable;"),
    SUB("invokestatic Operations/sub(LVariable;LVariable;)LVariable;"),
    DIV("invokestatic Operations/div(LVariable;LVariable;)LVariable;"),
    GREATER("invokestatic Operations/greater(LVariable;LVariable;)LVariable;"),
    LESS("invokestatic Operations/less(LVariable;LVariable;)LVariable;"),
    AND("invokestatic Operations/and(LVariable;LVariable;)LVariable;"),
    OR("invokestatic Operations/or(LVariable;LVariable;)LVariable;"),
    ALOAD("aload"),
    ARETURN("areturn"),
    DUP("dup"),
    NEWVAR("new Variable"),
    INVOKE("invokespecial Variable/<init>"),
    NEWBERNOUILLI("new Bernouilli"),
    INITBERNOUILLI("invokespecial Bernouilli/<init>(LVariable;)V"),
    NEWNORMAL("new Normal"),
    INITNORMAL("invokespecial Normal/<init>(LVariable;LVariable;)V"),
    NEWFLIP("new Flip"),
    INITFLIP("invokespecial Flip/<init>(LVariable;)V"),
    NEWBETA("new Beta"),
    INITBETA("invokespecial Beta/<init>(LVariable;LVariable;)V"),
    INITDISTR("invokespecial Variable/<init>(LDistribution;)V"),
    GETOBRESULT("invokestatic Operations/getObservResult(LVariable;)I"),
    SAMPLE("invokevirtual Variable/sample()LVariable;"),
    ASSERT("ifeq Expr"),
    CONTINUELABEL("Expr:"),
    MAKEFAILOBJECT("invokestatic Operations/makeFailObject()LVariable;"),
    GOTOPRINT("goto Print"),
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
