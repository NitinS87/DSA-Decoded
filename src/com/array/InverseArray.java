package com.array;

import java.util.Scanner;

public class InverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int[] inv = inverse(arr);
        display(inv);
    }

    private static int[] inverse(int[] arr) {
        int[] inv = new int[arr.length];
        for(int i=0;i< arr.length;i++){
            //take the element and
            //make it index of inverse arr
            //then assign value at this index as i
            int index = arr[i];
            inv[index] = i;
        }

        return inv;
    }

    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val).append("\n");
        }
        System.out.println(sb);
    }

}
