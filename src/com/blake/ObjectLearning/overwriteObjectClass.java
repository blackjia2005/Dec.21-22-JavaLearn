package com.blake.ObjectLearning; /**
 * Dec.17 26面向对象编程Object类
 * 重写 object Class 里面的 equals
 */

import java.util.Objects;

public class overwriteObjectClass {
    public static void main(String[] args) {
        employee blake = new employee(21060721, "Blake");
        employee blakeJia = new employee(21060721, "Blake");

        System.out.println(blake == blakeJia);
        System.out.println(blake.equals(blakeJia));
    }
}

class employee{
    int Id;
    String name;
    public employee(int ID,String name){
        this.Id = ID;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        employee employee = (employee) o;
        return Id == employee.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}