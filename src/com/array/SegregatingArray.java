package com.array;

import java.util.Scanner;

import static com.array.RotateArray.display;

//Given an array which consists of only 0, 1 and 2.
//Sort the array without using any sorting algo
public class SegregatingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        sort012(arr);
        display(arr);
    }

    private static void sort012(int[] arr) {
        int count0=0;
        int count1=0;
        int count2=0;

        for (int j : arr) {
            if (j == 0) {
                count0++;
            }
            if (j == 1) {
                count1++;
            }
            if (j == 2) {
                count2++;
            }
        }

        int index=0;
        for(int i=1;i<=count0;i++)
            arr[index++] = 0;
        for(int i=1;i<=count1;i++)
            arr[index++] = 1;
        for(int i=1;i<=count2;i++)
            arr[index++] = 2;
    }

}
