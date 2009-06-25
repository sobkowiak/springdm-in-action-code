#!/bin/sh

echo "Compile class Calculator.java"
javac com/manning/sdmia/osgi/nativecode/Calculator.java
echo "Create native interface for Calculator"
javah -jni com.manning.sdmia.osgi.nativecode.Calculator

echo "Compile native library code"
gcc -I/usr/lib/jvm/java-6-sun/include -I/usr/lib/jvm/java-6-sun/include/linux -c -o Calculator.o Calculator.c
echo "Create native library"
gcc -I/usr/lib/jvm/java-6-sun/include -I/usr/lib/jvm/java-6-sun/include/linux -shared -o libmathematical.so Calculator.o com_manning_sdmia_osgi_nativecode_Calculator.h
