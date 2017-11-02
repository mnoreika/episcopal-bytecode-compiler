.class public BetaSample
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
ldc 4.0
invokespecial Variable/<init>(F)V
new Variable
dup
ldc 5.0
invokespecial Variable/<init>(F)V
invokestatic Distributions/Beta(LVariable;LVariable;)LVariable;
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
return
.end method


