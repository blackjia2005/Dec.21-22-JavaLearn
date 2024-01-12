package com.blake.CollectionLearning;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] values = {4,3,1,5,2,7,0,9,8};
        int temp;
        boolean flag = true; // 标记

        for (int i = 0; i < values.length; i++){
            for (int j = 0; j < (values.length - i - 1) ; j++){
                if (values[j] > values[j+1]){
                    temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;

                    flag = false;
                }
                System.out.println("第"+i+"趟，第"+j+"次结果："+Arrays.toString(values));
            }
            if (flag){
                System.out.println("排序结束！");
                break;
            }else{
                flag = true;
            }
        }
        System.out.println(Arrays.toString(values));
    }
}
