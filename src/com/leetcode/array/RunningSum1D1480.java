package com.leetcode.array;

import java.util.Scanner;

public class RunningSum1D1480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int[] ans = runningSum(arr);
        for(int val: ans)
            System.out.println(val);
    }

    public static int[] runningSum(int[] nums) {
        //return a running sum array having elements
        //with sum of all before elements
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
        return nums;

    }
}
