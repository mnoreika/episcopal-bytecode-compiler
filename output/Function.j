.class public  Function
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
ldc 15
invokespecial lib/Variable/<init>(I)V
new lib/Variable
dup
ldc 12
invokespecial lib/Variable/<init>(I)V
invokestatic Function/funcA(Llib/Variable;Llib/Variable;)Llib/Variable;
Print:
getstatic java/lang/System/out Ljava/io/PrintStream;
swap 
invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
return
.end method

.method public static funcA(Llib/Variable;Llib/Variable;)Llib/Variable;
.limit stack 20
.limit locals 20
aload 0
aload 0
aload 1
invokestatic lib/Operations/add(Llib/Variable;Llib/Variable;)Llib/Variable;
invokestatic lib/Operations/add(Llib/Variable;Llib/Variable;)Llib/Variable;
areturn
.end method

