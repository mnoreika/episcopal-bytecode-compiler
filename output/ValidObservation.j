.class public ValidObservation
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
ldc 42
invokespecial Variable/<init>(I)V
new Variable
dup
ldc 42
invokespecial Variable/<init>(I)V
invokestatic Operations/equals(LVariable;LVariable;)LVariable;
invokestatic Operations/getObservResult(LVariable;)I
ifeq Expr
invokestatic Operations/makeFailObject()LVariable;
goto Print
Expr:
new Variable
dup
ldc 42
invokespecial Variable/<init>(I)V
new Variable
dup
ldc 42
invokespecial Variable/<init>(I)V
invokestatic Operations/add(LVariable;LVariable;)LVariable;
Print:
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
return
.end method

