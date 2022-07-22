package com.array;

import java.util.Scanner;

public class BrokenEconomy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int x = sc.nextInt();
        ceilAndFloor(arr, x);
    }

    private static void ceilAndFloor(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int mid;
        boolean flag = false;
        while(low<=high){
            mid = low+(high-low) / 2;
            if(x == arr[mid])
                flag = true;

            if(x<arr[mid])
                high=mid-1;

            else
                low=mid+1;
        }

        if(flag)
            System.out.println("Yes " + x + " denomination available");
        else
            System.out.println("Only " + arr[low] + " and " + arr[high] + " denominations are available.");

    }
}
