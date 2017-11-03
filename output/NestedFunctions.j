.class public  NestedFunctions
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
ldc 7
invokespecial lib/Variable/<init>(I)V
invokestatic NestedFunctions/funcB(Llib/Variable;)Llib/Variable;
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
ldc 5
invokespecial lib/Variable/<init>(I)V
aload 0
invokestatic lib/Operations/add(Llib/Variable;Llib/Variable;)Llib/Variable;
areturn
.end method

.method public static funcB(Llib/Variable;)Llib/Variable;
.limit stack 20
.limit locals 20
aload 0
invokestatic NestedFunctions/funcA(Llib/Variable;)Llib/Variable;
new lib/Variable
dup
ldc 20.5
invokespecial lib/Variable/<init>(F)V
invokestatic lib/Operations/add(Llib/Variable;Llib/Variable;)Llib/Variable;
areturn
.end method

