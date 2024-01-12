package com.blake.CollectionLearning;

public class myInteger {

    private int value;
    private static myInteger[] cache = new myInteger[256];

    public static final int HIGH = 128;
    public static final int LOW = -127;

    static{
        for (int i = LOW; i <= HIGH; i++){
            cache[i+(-LOW)] = new myInteger(i);
        }
    }

    public static myInteger valueOf(int i){
        if (i>=LOW && i<= HIGH){
            return cache[i-LOW];
        }else {
            return new myInteger(i);
        }
    }

    public int intValue(){
        return value;
    }

    public String toString(){
        return value+"";
    }

    private myInteger(int i){
        this.value = i;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
