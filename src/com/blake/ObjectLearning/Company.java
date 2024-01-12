package com.blake.ObjectLearning;

/**
 * Dec.17 22图形化分析内存_static的本质
 */
public class Company {
    static String CompanyName = "Blake Jia's com.blake.ObjectLearning.Company";
    static int CompanyID = 0;

    static {
        System.out.println("初始化程序调用");          // 静态的初始化，其实没啥用
        CompanyID = 1233;
    }

    static void companyInfo(){
        System.out.println("this is "+CompanyName);
    }

    void login(){
        System.out.println("you are logging in ...");
    }

    public static void main(String[] args) {
        Company.companyInfo();
        System.out.println("-----------------");
        Company My_company = new Company();           // 只会初始化一次
        My_company.login();
        My_company.companyInfo();                     // 不建议，建议直接写companyInfo()
    }
}
