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
new Beta
dup
new Variable
dup
ldc 14.5
invokespecial Variable/<init>(F)V
new Variable
dup
ldc 20.0
invokespecial Variable/<init>(F)V
invokespecial Beta/<init>(LVariable;LVariable;)V
invokespecial Variable/<init>(LDistribution;)V
invokevirtual Variable/sample()LVariable;
Print:
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
return
.end method

