package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSum2Leetcode40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();
        combinationSum2(arr, target);
    }

    private static void combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        findDifferentCombinations(0, arr, target, ans, new ArrayList<>());
        System.out.println(ans);
    }

    private static void findDifferentCombinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(target==0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index; i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1])
                continue;
            if(arr[i]>target)
                break;

            ds.add(arr[i]);
            findDifferentCombinations(i+1, arr, target-arr[i], ans, ds);
            ds.remove(ds.size()-1);
        }
    }
}
