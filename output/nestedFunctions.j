.class public nestedFunctions
.super java/lang/Object
.method public <init>()V
   aload_0
   invokespecial java/lang/Object/<init>()V
   return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 20
.limit locals 20

new Variable
dup
ldc 7
invokespecial Variable/<init>(I)V
invokestatic nestedFunctions/funcB(LVariable;)LVariable;
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
return
.end method

.method public static funcA(LVariable;)LVariable;
.limit stack 10
.limit locals 10
new Variable
dup
ldc 5
invokespecial Variable/<init>(I)V
aload 0
invokestatic Operations/add(LVariable;LVariable;)LVariable;
areturn
.end method

.method public static funcB(LVariable;)LVariable;
.limit stack 10
.limit locals 10
aload 0
invokestatic nestedFunctions/funcA(LVariable;)LVariable;
new Variable
dup
ldc 20.5
invokespecial Variable/<init>(F)V
invokestatic Operations/add(LVariable;LVariable;)LVariable;
areturn
.end method

