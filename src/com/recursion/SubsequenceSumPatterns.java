package com.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SubsequenceSumPatterns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int sum = sc.nextInt();
        ArrayList<Integer> ds = new ArrayList<>();
        System.out.println("Print all subsequences: ");
        printSubAllSum(0,arr,ds,  sum, 0);
        System.out.println("Print only one subsequence: ");
        printSubOneSum(0, arr, ds, sum, 0);
        System.out.println("Print count of no of subsequences: ");
        int count = countSubSum(0, arr, sum, 0);
        System.out.println(count);
    }

    private static int countSubSum(int i, int[] arr, int sum, int s) {
        //going forward, condition is not going to satisfy
        //strictly done if array elements are positive
        if(s>sum) return 0;
        //base case condition
        if(i== arr.length){
            //condition satisfied
            if(s==sum) return 1;
            //condition not satisfied
            else return 0;
        }

        //pick condition
        s += arr[i];
        int l = countSubSum(i+1, arr, sum, s);
        s -= arr[i];
        //not pick condition
        int r = countSubSum(i+1, arr, sum, s);

        return l+r;
    }

    private static boolean printSubOneSum(int i, int[] arr, ArrayList<Integer> ds, int sum, int s) {
        //going forward, condition is not going to satisfy
        //strictly done if array elements are positive
        if(s>sum) return false;
        //base case condition
        if(i== arr.length){
            //condition satisfied
            if(s==sum){
                System.out.println(ds);
                return true;
            }
            //condition not satisfied
            else return false;
        }

        //pick condition
        ds.add(arr[i]);
        s += arr[i];
        if(printSubOneSum(i+1, arr, ds, sum, s))
            return true;
        s -= arr[i];
        ds.remove(ds.size()-1);
        //not pick condition
        if(printSubOneSum(i+1, arr, ds, sum, s))
            return true;

        return false;

    }

    private static void printSubAllSum(int i, int[] arr, ArrayList<Integer> ds, int sum, int s) {
        //going forward, condition is not going to satisfy\
        //strictly done if array elements are positive
        if(s>sum) return;
        //base case condition
        if(i== arr.length){
            if(s==sum){
                System.out.println(ds);
            }
            return;
        }

        //pick condition
        ds.add(arr[i]);
        s += arr[i];
        printSubAllSum(i+1, arr, ds, sum, s);
        s -= arr[i];
        ds.remove(ds.size()-1);
        //not pick condition
        printSubAllSum(i+1, arr, ds, sum, s);

    }

}
