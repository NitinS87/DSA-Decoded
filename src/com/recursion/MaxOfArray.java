package com.recursion;

import java.util.Scanner;

public class MaxOfArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int max = maxOfArray(arr, 0);
        System.out.println(max);
    }

    private static int maxOfArray(int[] arr, int idx) {
        if(idx == arr.length-1)
            return arr[idx];
        int misa = maxOfArray(arr, idx+1);
        if(misa<arr[idx])
            return arr[idx];
        else
            return misa;
    }
}
