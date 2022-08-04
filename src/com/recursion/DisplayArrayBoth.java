package com.recursion;

import java.util.Scanner;

public class DisplayArrayBoth {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        displayArr(arr, 0);
    }

    private static void displayArr(int[] arr, int idx) {
        if(idx == arr.length)
            return;
        //these two lines will print in increasing order
        System.out.println(arr[idx]);
        displayArr(arr, idx+1);
        //after that the index starts reducing, and we will print in reverse order
        System.out.println(arr[idx]);
    }
}
