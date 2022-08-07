package com.array;

import java.util.Scanner;

public class MoveZeroesOrdered {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        moveZeroes(arr);
        for(int val: arr)
            System.out.println(val);
    }

    private static void moveZeroes(int[] arr) {
        //idea is to find the last non-zero element in array and add zeroes after all of it
        int lastNonZeroFoundAt=0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for(int i=0;i< arr.length;i++){
            if(arr[i]!=0)
                arr[lastNonZeroFoundAt++] = arr[i];
        }

        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < arr.length; i++) {
            arr[i] = 0;
        }

    }
}
