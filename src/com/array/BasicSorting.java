package com.array;

import java.util.Scanner;

public class BasicSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        bubble(arr);
        printArray(arr);
        insertion(arr);
        printArray(arr);
        selection(arr);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for(int i: arr)
            System.out.print(i + " ");
        System.out.println();
    }

    private static void bubble(int[] arr) {
        //in bubble sort
        //the maximum element is first swapped with last index
        //then after that we don't touch maximum element
        //and then sort the second-last
        //1 8 3 4 6
        //1st - 1 6 3 4 8
        //2nd - 1 4 3 6 8
        //3rd - 1 3 4 6 8
        //4th - 1 3 4 6 8 --answer
        //time complexity - O(N^2)

        for(int i=0;i< arr.length-1;i++){
            for(int j=0;j< arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    //swap them
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    private static void selection(int[] arr) {
        //in selection sort
        //we find the smallest element and place it at first index
        //then we start sorting after second index
        //1 8 3 4 6
        //1st - 1 8 3 4 6
        //2nd - 1 3 8 4 6
        //3rd - 1 3 4 8 6
        //4th - 1 3 4 6 8 --answer
        //time complexity - O(N^2)
        for(int i=0;i< arr.length-1;i++){
            int smallest = i;
            for(int j=i+1;j< arr.length;j++){
                if(arr[smallest]>arr[j])
                    smallest=j;
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }

    private static void insertion(int[] arr) {
        //in insertion sort
        //there are two parts of array - sorted and unsorted
        //we compare elements of unsorted array with all sorted array elements
        //then place at its right position
        //1 8 3 4 6
        //1st - 1 8 3 4 6 current = 8
        //2nd - 1 3 8 4 6 current = 3
        //3rd - 1 3 4 8 6 current = 4
        //4th - 1 3 4 6 8 current = 6

        //unsorted elements loop
        for(int i=1;i< arr.length;i++){
            //unsorted element
            int current = arr[i];
            //sorted elements
            int j = i-1;
            //sorted part loop
            while(j>=0 && current<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            //placement
            arr[j+1] = current;
        }

    }
}
