.class public BernouilliSample
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
new Bernouilli
dup
new Variable
dup
ldc 0.7
invokespecial Variable/<init>(F)V
invokespecial Bernouilli/<init>(LVariable;)V
invokespecial Variable/<init>(LDistribution;)V
invokevirtual Variable/sample()LVariable;
Print:
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
return
.end method

