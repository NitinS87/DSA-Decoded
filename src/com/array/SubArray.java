package com.array;

import java.util.Scanner;

public class SubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        subArrays(arr);
    }

    private static void subArrays(int[] arr) {
        for(int i=0;i< arr.length;i++){
            for(int j=i;j< arr.length;j++){
                for (int k=i;k<=j;k++)
                    System.out.print(arr[k] + "\t");
                System.out.println();
            }

        }
    }
}
