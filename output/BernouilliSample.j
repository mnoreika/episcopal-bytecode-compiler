.class public  BernouilliSample
.super java/lang/Object
.method public <init>()V
   aload_0
   invokespecial java/lang/Object/<init>()V
   return
.end method
.method public static main([Ljava/lang/String;)V
.limit stack 20
.limit locals 20

new lib/Variable
dup
new lib/Bernouilli
dup
new lib/Variable
dup
ldc 0.7
invokespecial lib/Variable/<init>(F)V
invokespecial lib/Bernouilli/<init>(Llib/Variable;)V
invokespecial lib/Variable/<init>(Llib/Distribution;)V
invokevirtual lib/Variable/sample()Llib/Variable;
Print:
getstatic java/lang/System/out Ljava/io/PrintStream;
swap 
invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
return
.end method

