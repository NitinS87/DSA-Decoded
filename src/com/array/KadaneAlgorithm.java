package com.array;

import java.util.Scanner;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println("Maximum sum is: ");
        System.out.println(kadane(arr));
    }

    private static int kadane(int[] arr) {
        //this has overall time complexity O(n)
        //the idea is if adding negative numbers we get currSum=0
        //then reset it and start for next elements
        int maxSum = Integer.MIN_VALUE;
        int currSum=0;
        for (int i : arr) {
            currSum += i;
            if (maxSum < currSum)
                maxSum = currSum;
            if (currSum < 0)
                currSum = 0;
        }

        return maxSum;
    }


}
