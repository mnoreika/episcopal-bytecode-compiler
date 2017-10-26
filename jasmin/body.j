ldc 0
istore 1
iinc 1 -1
w:
ldc 10
iload 1
i2l
dup2_x1
pop2
i2l
lcmp
ifeq w_done
getstatic java/lang/System/out Ljava/io/PrintStream;
iload 1
invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
iinc 1 1
goto w
w_done:
