package com.array;

import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int x = sc.nextInt();
        firstAndLastIndex(arr, x);
    }

    private static void firstAndLastIndex(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;
        int fi = -1;

        boolean flag = false;
        while (low<=high){
            int mid = (low+high) / 2;
            if(x > arr[mid]){
                low = mid+1;
            }
            else if(x<arr[mid]){
                high = mid-1;
            }else{
                fi = mid;
                high= mid-1;
                flag = true;
            }
        }
        if(flag)
            System.out.println(fi);
        else
            System.out.println("Not found");

        low = 0;
        high = arr.length-1;
        int li = -1;

        flag = false;
        while (low<=high){
            int mid = (low+high) / 2;
            if(x > arr[mid]){
                low = mid+1;
            }
            else if(x<arr[mid]){
                high = mid-1;
            }else{
                li = mid;
                low = mid+1;
                flag = true;
            }
        }
        if(flag)
            System.out.println(li);
        else
            System.out.println("Not found");

    }
}
