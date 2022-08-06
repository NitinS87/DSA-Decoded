package com.leetcode.array;

import java.util.Scanner;

//The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the
//sum of all the numbers strictly to the index's right.
public class PivotIndex724 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int pivot = pivotIndex(arr);
        System.out.println(pivot);
    }
    public static int pivotIndex(int[] arr) {
        //take first element of array as pivot point
        //initialize leftSum and rightSum as 0 and
        //find out find the leftSum for left side
        //and rightSum for right side of pivot
        //check if both are equal or not

        //take first element of array as pivot point
        int index=0;
        while(index< arr.length){
            //initialize leftSum and rightSum as 0 and
            int leftSum=0;
            int rightSum=0;
            //find out the leftSum for left side
            for(int i=0;i<index;i++){
                leftSum += arr[i];
            }
            //and rightSum for right side of pivot
            for(int i=index+1;i< arr.length;i++){
                rightSum += arr[i];
            }

            //check if both are equal or not
            if(leftSum==rightSum)
                return index;
            index++;
        }

        return -1;
    }
}
