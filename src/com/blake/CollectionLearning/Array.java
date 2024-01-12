package com.blake.CollectionLearning;

import java.util.*;

/**
 * Dec.19
 * 34数组和算法_一维数组
 * 35数组和算法_多维数组
 * 对象的数组 -- 表格的存储
 */
public class Array {
    public static void main(String[] args) {
        Job a1 = new Job(1,"full time student","2023-09-01");
        Job a2 = new Job(2,"Gyubee waiter","2023-11-21");
        Job a3 = new Job(3,"Group Facilitator","2023-12-18");
        Job a4 = new Job(4,"More...","After 2023-12-20");

        List<Job> my_job = new ArrayList<>();
        my_job.add(a1);
        my_job.add(a2);
        my_job.add(a3);
        my_job.add(a4);

        // 使用iterator删除列表中元素 --> 以防list.length有变化
        for (Iterator<Job> iter = my_job.iterator(); iter.hasNext();) {
            Job temp = iter.next();
            if (temp.id == 3) {
                iter.remove();
            }
            System.out.println(temp.toString());
        }
        System.out.println(my_job.toString());
    }
}

class Job{
    int id;
    String job;
    String hiredate;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", job='" + job + '\'' +
                ", hiredate='" + hiredate + '\'' +
                '}';
    }

    public Job(int id, String job, String hiredate) {
        this.id = id;
        this.job = job;
        this.hiredate = hiredate;
    }

}