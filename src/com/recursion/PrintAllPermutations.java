package com.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintAllPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        permutations(arr);
    }

    private static void permutations(int[] arr) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];
        findPermutes(arr, ds, freq, ansList);
        findPermutes2(0, arr, ansList);
        System.out.println(ansList);
    }

    private static void findPermutes2(int index, int[] arr, List<List<Integer>> ansList) {
        if(index== arr.length){
            //copy the ds to ans
            List<Integer> ds = new ArrayList<>();
            for (int j : arr) {
                ds.add(j);
            }
            ansList.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i< arr.length;i++){
            swap(i, index, arr);
            findPermutes2(index+1, arr, ansList);
            swap(i, index, arr);
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void findPermutes(int[] arr, List<Integer> ds, boolean[] freq, List<List<Integer>> ansList) {
        if(ds.size()== arr.length){
            ansList.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(arr[i]);
                findPermutes(arr, ds, freq, ansList);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }

    }
}
