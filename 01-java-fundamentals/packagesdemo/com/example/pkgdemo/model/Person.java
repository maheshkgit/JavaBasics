package com.example.pkgdemo.model;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String greet() {
        return "Hello, my name is " + name;
    }
}
