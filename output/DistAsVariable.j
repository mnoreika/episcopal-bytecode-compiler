.class public  DistAsVariable
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
ldc 0.5
invokespecial lib/Variable/<init>(F)V
invokestatic DistAsVariable/funcA(Llib/Variable;)Llib/Variable;
invokevirtual lib/Variable/sample()Llib/Variable;
Print:
getstatic java/lang/System/out Ljava/io/PrintStream;
swap 
invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
return
.end method

.method public static funcA(Llib/Variable;)Llib/Variable;
.limit stack 20
.limit locals 20
new lib/Variable
dup
new lib/Bernouilli
dup
aload 0
invokespecial lib/Bernouilli/<init>(Llib/Variable;)V
invokespecial lib/Variable/<init>(Llib/Distribution;)V
areturn
.end method

