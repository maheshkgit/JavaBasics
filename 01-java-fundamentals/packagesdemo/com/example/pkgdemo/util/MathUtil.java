package com.example.pkgdemo.util;

/*
 * Packages
 * ---------
 * Packages group related classes together, avoid naming collisions, and control
 * visibility (package-private members are shared within the package).
 * Directory structure MUST mirror the package name:
 *   com.example.pkgdemo.util  ->  com/example/pkgdemo/util/MathUtil.java
 */
public class MathUtil {
    public static int square(int n) {
        return n * n;
    }
}
