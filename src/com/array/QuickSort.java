package com.array;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        //in this we find a pivot point and sort elements on the basis of it
        //smaller elements gets on left side
        //larger elements gets on right side of pivots
        if(low>=high)
            return;

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];

        while(start<=end){
            while(arr[start]<pivot)
                start++;
            while(arr[end]>pivot)
                end--;

            if(start<=end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        //as after above loop executed, start and end have crossed each other
        //now my pivot is at correct index, place sort two halves now
        quickSort(arr, low, end);
        quickSort(arr, start, high);

    }
}
