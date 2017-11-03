.class public function
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
ldc 15
invokespecial Variable/<init>(I)V
new Variable
dup
ldc 12
invokespecial Variable/<init>(I)V
invokestatic Function/funcA(LVariable;LVariable;)LVariable;
Print:
getstatic java/lang/System/out Ljava/io/PrintStream;
swap
invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
return
.end method

.method public static funcA(LVariable;LVariable;)LVariable;
.limit stack 10
.limit locals 10
aload 0
aload 0
aload 1
invokestatic Operations/add(LVariable;LVariable;)LVariable;
invokestatic Operations/add(LVariable;LVariable;)LVariable;
areturn
.end method

