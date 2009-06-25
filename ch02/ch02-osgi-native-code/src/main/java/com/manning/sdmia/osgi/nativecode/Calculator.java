/**
 * 
 */
package com.manning.sdmia.osgi.nativecode;

/**
 * @author ttemplier
 *
 */
public class Calculator {
    static {
        System.loadLibrary("mathematical");
    }

    public native int add(int i1, int i2);

    public static void main(String[] args) {
    	Calculator calculator = new Calculator();
        System.out.println("1 + 1 = " + calculator.add(1, 1));
    }
}

