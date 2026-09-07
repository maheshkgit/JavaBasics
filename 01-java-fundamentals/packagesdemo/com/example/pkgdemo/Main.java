package com.example.pkgdemo;

// Importing classes from other packages
import com.example.pkgdemo.util.MathUtil;
import com.example.pkgdemo.model.Person;

public class Main {
    public static void main(String[] args) {
        System.out.println("square(6) via util package = " + MathUtil.square(6));

        Person p = new Person("Mah");
        System.out.println(p.greet());
    }
}
