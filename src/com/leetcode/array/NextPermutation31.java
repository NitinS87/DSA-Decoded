package com.leetcode.array;

import java.util.Scanner;

public class NextPermutation31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        nextPermutation(arr);
        for(int i: arr)
            System.out.print(i + " ");
    }
    public static void nextPermutation(int[] arr) {
        //the elements most time are in increasing then decreasing order
        //4 1 5 3 2 -> 4 2 1 5 3
        //first replace 2 with 1
        //then reverse the array
        //if only one element exists
        if(arr.length==1)
            return;

        //find first element from the back which is just lower than last element
        int idx1 = -1;
        for(int i= arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                idx1=i;
                break;
            }
        }
        //if we can't find index1 then this array must be the biggest permutation possible
        //hence we just reverse it to make its smallest permutation
        if(idx1<0){
            reverse(arr, 0, arr.length-1);
        }
        else {
            //we find an element which is greater than idx1
            int idx2=0;
            for(int i= arr.length-1;i>=0;i--){
                //now we have to find
                if (arr[i]>arr[idx1]){
                    idx2 = i;
                    break;
                }
            }

            //after that swap both numbers
            swap(arr, idx1, idx2);
            //then reverse the array after index
            reverse(arr, idx1+1, arr.length-1);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int i, int j) {
        int li = i;
        int ri = j;

        while(li<ri){
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;

            li++;
            ri--;
        }
    }

}
