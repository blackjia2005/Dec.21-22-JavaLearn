package com.blake.ObjectLearning;

/**
 *  29面向对象编程_多态_对象的转型（向上、向下）
 *  同一个函数不一样的表示
 *  30面向对象编程_抽象类和抽象方法
 */
public class AbstractAndMutipo {
    public static void main(String[] args) {
        Dog dog = new Dog("黄黄");
        Cat cat1 = new Cat("妙妙");
        Cat cat2 = new Cat("奇奇");

        cat1.shout();
        cat2.shout();
        dog.shout();
    }
}

abstract class Animal{              // abstract class 
    String name;
    public Animal(String name){
        this.name = name;
    }

    public abstract void shout();    // abstract functions

    public void sleep() {
        System.out.println(this.name + " is sleeping...");
    }
}

class Cat extends Animal{
    Cat(String name){
        super(name);
    }

    @Override
    public void shout() {
        System.out.println(this.name + " 喵喵喵！");
    }
}

class Dog extends Animal{
    public Dog(String name){
        super(name);
    }

    @Override
    public void shout() {
        System.out.println(this.name+" 汪汪汪！");
    }
}


