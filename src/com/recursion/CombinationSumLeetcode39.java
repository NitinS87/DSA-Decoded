package com.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSumLeetcode39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();

        combinationSum(arr, target);
    }

    private static void combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, arr, target, ans, new ArrayList<>());
        System.out.println(ans);
    }

    private static void findCombinations(int i, int[] arr, int target, List<List<Integer>> ans, ArrayList<Integer> ds) {
        //base case conditions
        if(i== arr.length){
            //condition satisfied
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            //not satisfied
            return;
        }

        //pick the same index
        if(arr[i]<=target){
            ds.add(arr[i]);
            findCombinations(i, arr, target-arr[i], ans, ds);
            ds.remove(ds.size()-1);
        }
        //pick the next index
        findCombinations(i+1, arr, target, ans, ds);
    }
}
