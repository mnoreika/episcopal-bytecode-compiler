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
.method public static funcA(II)I 
ldc 7
ldc 5
invokestatic path

invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
return
.end method