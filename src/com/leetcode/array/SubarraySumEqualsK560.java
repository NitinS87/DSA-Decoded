package com.leetcode.array;

import java.util.Scanner;

public class SubarraySumEqualsK560 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int s = sc.nextInt();
        System.out.println(subarraySum(arr, s));
    }

    private static int subarraySum(int[] arr, int s) {
        int count = 0;
        //sumArray has sum of all previous elements of array
        int[] sumArray = new int[arr.length + 1];
        sumArray[0] = 0;

        //add all previous elements of sum and array previous element at index
        for (int i = 1; i <= arr.length; i++)
            sumArray[i] = sumArray[i - 1] + arr[i - 1];


        //traverse through the new sum array and check at which intervals we get desired sum
        for(int i=0;i< sumArray.length;i++){
            for(int j=i+1;j< sumArray.length;j++){
                if(sumArray[j]-sumArray[i] == s)
                    count++;
            }
        }

        return count;
    }
}
