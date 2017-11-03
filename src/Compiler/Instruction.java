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
    PRINT("Print:\n" +
          "getstatic java/lang/System/out Ljava/io/PrintStream;\n" +
          "swap \n" +
          "invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V"),
    STACKLIMIT(".limit stack 20"),
    LOCALSLIMIT(".limit locals 20"),
    INVSTATIC("invokestatic "),
    CLASS(".class public "),
    SUPER(".super java/lang/Object"),
    ENDMETHOD(".end method"),
    RETURN("return"),
    LDC("ldc"),
    PLUS("invokestatic lib/Operations/add(Llib/Variable;Llib/Variable;)Llib/Variable;"),
    EQUALS("invokestatic lib/Operations/equals(Llib/Variable;Llib/Variable;)Llib/Variable;"),
    MULT("invokestatic lib/Operations/mult(Llib/Variable;Llib/Variable;)Llib/Variable;"),
    SUB("invokestatic lib/Operations/sub(Llib/Variable;Llib/Variable;)Llib/Variable;"),
    DIV("invokestatic lib/Operations/div(Llib/Variable;Llib/Variable;)Llib/Variable;"),
    GREATER("invokestatic lib/Operations/greater(Llib/Variable;Llib/Variable;)Llib/Variable;"),
    LESS("invokestatic lib/Operations/less(Llib/Variable;Llib/Variable;)Llib/Variable;"),
    AND("invokestatic lib/Operations/and(Llib/Variable;Llib/Variable;)Llib/Variable;"),
    OR("invokestatic lib/Operations/or(Llib/Variable;Llib/Variable;)Llib/Variable;"),
    ALOAD("aload"),
    ARETURN("areturn"),
    DUP("dup"),
    NEWVAR("new lib/Variable"),
    INVOKE("invokespecial lib/Variable/<init>"),
    NEWBERNOUILLI("new lib/Bernouilli"),
    INITBERNOUILLI("invokespecial lib/Bernouilli/<init>(Llib/Variable;)V"),
    NEWNORMAL("new lib/Normal"),
    INITNORMAL("invokespecial lib/Normal/<init>(Llib/Variable;Llib/Variable;)V"),
    NEWFLIP("new lib/Flip"),
    INITFLIP("invokespecial lib/Flip/<init>(Llib/Variable;)V"),
    NEWBETA("new lib/Beta"),
    INITBETA("invokespecial lib/Beta/<init>(Llib/Variable;Llib/Variable;)V"),
    INITDISTR("invokespecial lib/Variable/<init>(Llib/Distribution;)V"),
    GETOBRESULT("invokestatic lib/Operations/getObservResult(Llib/Variable;)I"),
    SAMPLE("invokevirtual lib/Variable/sample()Llib/Variable;"),
    ASSERT("ifeq Expr"),
    CONTINUELABEL("Expr:"),
    MAKEFAILOBJECT("invokestatic lib/Operations/makeFailObject()Llib/Variable;"),
    GOTOPRINT("goto Print"),
    TYPEINT("I"),
    TYPEFLOAT("F"),
    TYPEBOOLEAN("Z"),
    TYPEVARIABLE("Llib/Variable;");

    private String value;

    Instruction(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
