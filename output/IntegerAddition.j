.class public  IntegerAddition
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
ldc 41
invokespecial lib/Variable/<init>(I)V
new lib/Variable
dup
ldc 1
invokespecial lib/Variable/<init>(I)V
invokestatic lib/Operations/add(Llib/Variable;Llib/Variable;)Llib/Variable;
Print:
getstatic java/lang/System/out Ljava/io/PrintStream;
swap 
invokevirtual java/io/PrintStream/println(Ljava/lang/Object;)V
return
.end method

