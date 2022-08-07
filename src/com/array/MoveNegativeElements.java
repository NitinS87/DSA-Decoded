package com.array;

import java.util.Scanner;

public class MoveNegativeElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        moveNegatives(arr);
        for(int val: arr)
            System.out.println(val);
    }

    private static void moveNegatives(int[] arr) {
        int low=0;
        int mid=0;
        int high= arr.length-1;

        while(mid<=high){
            if(arr[mid]<0){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid++;
                low++;
            }
            else{
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                mid++;
                high--;
            }
        }
    }
}
