package com.blake.CollectionLearning;

import java.util.Arrays;

/**
 * Dec.20
 * 37数组和算法_二分法查找（折半查找）
 */

public class binarySearch {

    public static void main(String[] args) {

        int[] my_arr = {1,7,4,9,3,5,6,0};
        int searchNumber = 4;

        // Binary Search requires a sorted list
        Arrays.sort(my_arr);
        System.out.println(Arrays.toString(my_arr));

        int answer = binarySearch(my_arr,searchNumber);
        System.out.println(answer);
    }
    
    // BinarySearch
    private static int binarySearch(int[] l,int value){
        int LOW = 0;
        int HIGH = l.length-1;

        while (LOW<=HIGH){
            int middle = (LOW+HIGH)/2;
            System.out.println(LOW+" "+middle+" "+HIGH);

            if (value == l[middle]){
                return middle;
            }
            if (value > l[middle]){
                LOW = middle+1;
            }
            if (value < l[middle]){
                HIGH = middle-1;
            }
        }

        return -1; // 没找到
    }
}
