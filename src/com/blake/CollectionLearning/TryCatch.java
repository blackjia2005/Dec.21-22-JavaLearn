package com.blake.CollectionLearning;

/**
 * Dec.19 异常..
 * 42异常机制1
 * 43异常机制2
 * 44可视化bug追踪
 */

public class TryCatch{

    public static void main(String[] args) throws IligalAgeException {
        // System.out.println(test43());
        test44();
    }

    public static int test43(){
        int a = 5;
        System.out.println("Step1");
        try{
            a = 123;
            System.out.println("Step2");
            return a;
        }catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            a = 20;
            System.out.println("step3");
            return a;
        }
    }

    public static void test44() throws IligalAgeException {
        person a = new person();
        a.setAge(-8);
    }


}

class IligalAgeException extends Exception{

    public IligalAgeException(){}

    public IligalAgeException(String message){
        super(message);
    }
}

class person {
    private int age;

    public void setAge(int age) throws IligalAgeException {
        if (age<0){
            throw new IligalAgeException("a com.blake.CollectionLearning.person's age cannot be less than 0!");
        }else{
            this.age = age;
        }
    }
}