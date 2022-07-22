package com.array;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        int index = binarySearch(arr, 0, n-1, x);
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int low, int high, int x) {
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == x)
                return mid;

            if(arr[mid]<x){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return -1;
    }
}
