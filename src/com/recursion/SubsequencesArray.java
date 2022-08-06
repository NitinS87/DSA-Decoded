package com.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SubsequencesArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> subsequence = new ArrayList<>();
        printSubsequences(0,arr, subsequence);
    }

    private static void printSubsequences(int i, int[] arr, ArrayList<Integer> subsequence) {
        if(i == arr.length){
            if(subsequence.size()>0)
                System.out.println(subsequence);

            return;
        }

        //not pick condition
        printSubsequences(i+1, arr, subsequence);

        //pick condition
        subsequence.add(arr[i]);
        printSubsequences(i+1, arr, subsequence);
        subsequence.remove(subsequence.size()-1);
    }
}
