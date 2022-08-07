package com.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubSetSumDifferent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        subsetsSumDifferent(arr);
    }

    private static void subsetsSumDifferent(int[] arr) {
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, arr, new ArrayList<>(), ansList);
        System.out.println(ansList);
    }

    private static void findSubsets(int ind, int[] arr, ArrayList<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));
        for(int i=ind;i< arr.length;i++){
            if(i!=ind && arr[i]==arr[i-1])
                continue;

            ds.add(arr[i]);
            findSubsets(i+1, arr, ds, ansList);
            ds.remove(ds.size()-1);
        }

    }
}
