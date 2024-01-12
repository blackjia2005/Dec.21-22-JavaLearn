package com.blake.ObjectLearning;

/**
 * Dec.17 25面向对象编程_组合
 * 组合比较灵活，可以“继承”多个父
 * 类似 has-a， 而不是is-a
 */
public class composition {
    public static void main(String[] args) {
        computer my_computer = new computer("Blake","Blake's MacBook", "M2 Core");
        my_computer.play_game();
    }
}

class CPU{
    String name;

    public CPU(String name){
        this.name = name;
    }
    public CPU(){

    }
    public void calculate(){
        System.out.println(this.name+ "is Calculating...");
    }
}

class Memory{
    public void store(){
        System.out.println("memory.store");
    }
}

class computer{
    CPU cpu = new CPU();
    Memory my_memory = new Memory();
    String name;
    String Owner;

    public computer(String owner, String name, String CPUname){
        this.name = name;
        this.cpu.name = CPUname;
        this.Owner = owner;
    }

    public void play_game(){
        System.out.println(this.Owner+" is Using "+this.name+" Playing game");
        this.cpu.calculate();
    }
}