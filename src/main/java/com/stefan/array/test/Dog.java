package com.stefan.array.test;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
        System.out.println("Dog(String, int)");
    }

    public static void main(String[] args) {
        new Dog("aaa", 12);
    }
}
