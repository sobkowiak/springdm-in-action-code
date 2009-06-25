#include <jni.h>
#include "com_manning_sdmia_osgi_nativecode_Calculator.h"
#include <stdio.h>
JNIEXPORT jint JNICALL Java_com_manning_sdmia_osgi_nativecode_Calculator_add
  (JNIEnv *env, jobject obj, jint i1, jint i2)
{
    return i1+i2;
}

