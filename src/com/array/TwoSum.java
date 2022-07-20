package com.array;

import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();
        int[] ans = twoSums(arr, target);

        for (int item : ans) {
            System.out.println(item);
        }
    }

    private static int[] twoSums(int[] arr, int target) {
        int[] ans = {-1,-1};
        for(int i=0;i< arr.length;i++){
            for (int j=i+1;j< arr.length;j++){
                if(target == (arr[i] + arr[j])) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;

    }
}
