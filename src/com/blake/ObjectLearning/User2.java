package com.blake.ObjectLearning;

/**
 * Dec.17 21图形化分析内存_this的本质
 */
public class User2 {
    int id;
    String pwd;
    String name;

    public User2(int id,String name){       //初始化带参对象
        this.id = id;
        this.name = name;
    };

    public User2(int id, String name, String pwd){
        this(id,name);          //重载器
        this.pwd = pwd;
    }

    private void login(){
        System.out.println(this+"\n"+this.name+" 正在登录...");
    }  // private 只能在本文件中使用

    public static void main(String[] args) {
        User2 my_user1 = new User2(1001, "BlakeJia", "123456");
        my_user1.login();
        User2 my_user2 = new User2(1001, "BlakeJia", "123456");
        my_user2.login();
    }

}
