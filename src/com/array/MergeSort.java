package com.array;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(arr));
        mergeSortInPlace(arr, 0 , arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSortInPlace(int[] arr, int start, int end) {
        //divide the array
        //sort both of them
        //then merge them accordingly

        //9 5 6 3 1
        //1st - 9 5 || 6 3 1
        //2nd - 9 || 5 || 6 || 3 1
        //3rd - 5 9 || 6 || 3 || 1
        //4th - 5 9 || 6 || 1 3
        //5th - 5 9 || 1 3 6
        //6th - 1 3 5 6 9

        if(end-start==1)
            return;

        int mid = (start+end)/2;

        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end-start];
        int i=start;
        int j=mid;
        int k=0;
        while(i<mid && j<end){
            //check which element is smaller - start-element or mid-element
            //insert it in new mix array
            if(arr[i]<arr[j])
                mix[k++] = arr[i++];
            else
                mix[k++] = arr[j++];
        }

        //it may be possible that above loops terminates before either on of the arrays completes
        //if first array is not finished
        while (i<mid){
            mix[k++] = arr[i++];
        }
        //if second array is not finished
        while (j<end){
            mix[k++] = arr[j++];
        }

        //then copy the array from mix to original array
        for(int l=0;l< mix.length;l++)
            arr[start+l] = mix[l];
    }


    private static int[] mergeSort(int[] arr) {
        //divide the array
        //sort both of them
        //then merge them accordingly

        //9 5 6 3 1
        //1st - 9 5 || 6 3 1
        //2nd - 9 || 5 || 6 || 3 1
        //3rd - 5 9 || 6 || 3 || 1
        //4th - 5 9 || 6 || 1 3
        //5th - 5 9 || 1 3 6
        //6th - 1 3 5 6 9
        if(arr.length==1)
            return arr;
        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<first.length && j<second.length){
            //check which element is smaller - first's element or second's element
            //insert it in new mix array
            if(first[i]<second[j])
                mix[k++] = first[i++];
            else
                mix[k++] = second[j++];
        }

        //it may be possible that above loops terminates before either on of the arrays completes
        //if first array is not finished
        while (i<first.length){
            mix[k++] = first[i++];
        }
        //if second array is not finished
        while (j<second.length){
            mix[k++] = second[j++];
        }

        return mix;
    }

}
