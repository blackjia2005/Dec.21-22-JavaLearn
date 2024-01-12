package com.blake.ObjectLearning;

/**
 * Dec.17 24面向对象编程_继承_方法重写
 *        27面向对象编程_super和继承内存分析
 * super访问父累的方法和属性
 */
public class Student extends Person{
    final String major;                                                 // final -> cannot be over-written
    public Student(String name, int height, String major) {
        super();                                                        // 调用父类的 constructor
        this.name = name;
        this.height = height;
        this.major = major;
    }

    public void study(){
        System.out.println(this.name + " is studying " + this.major);
    }

    public void rest(){         // override
        System.out.println(this.name+", you cannot rest now!!!");
    }

    public static void main(String[] args) {
        Student blake = new Student("Blake", 183, "Java");
        blake.rest();
        blake.study();
        blake.printInfo();
    }
}

class People{
    int height = 173;
}

class Person extends People{
    int height;
    String name;

    public Person(){
    }

    public void rest(){
        System.out.println(this.name + " is Resting...");
    }

    final public void printInfo(){                                                 // final -> cannot be over-written
        System.out.println("my name is "+ this.name);
        System.out.println("this person's height is:"+this.height);                // this.height -> 183
        System.out.println("Most common height for a person is:"+super.height);    // super.height -> 173
    }
}