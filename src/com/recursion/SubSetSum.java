package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SubSetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        subsetSum(arr);
    }

    private static void subsetSum(int[] arr) {
        ArrayList<Integer> ds = new ArrayList<>();
        subsets(0, arr, 0, ds);
        Collections.sort(ds);
        System.out.println(ds);
    }

    private static void subsets(int ind, int[] arr, int sum,ArrayList<Integer> ds) {
        if(ind== arr.length){
            ds.add(sum);
            return;
        }
        //pick condition
        subsets(ind+1, arr, sum+arr[ind], ds);
        //not pick condition
        subsets(ind+1, arr, sum, ds);
    }


}
