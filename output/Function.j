.class public Function
.super java/lang/Object

.method public <init>()V
   aload_0
   invokespecial java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 20
.limit locals 20
getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 0.2
invokestatic Distributions/Bernoulli(F)I
invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
return
.end method

.method public static funcA(II)I
   .limit stack 2
   .limit locals 2
   iload 0
   iload 1
   imul
   ireturn
.end method
