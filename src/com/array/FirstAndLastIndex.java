package com.array;

import java.util.ArrayList;
import java.util.Scanner;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int x = sc.nextInt();
        ArrayList<Long> ans =  firstAndLastIndex(arr, x);
        System.out.println(ans);
    }

    private static ArrayList<Long> firstAndLastIndex(int[] arr, int x) {
        ArrayList<Long> ans = new ArrayList<>();
        int low = 0;
        int high = arr.length - 1;
        long fi = -1;

        boolean flag = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x > arr[mid]) {
                low = mid + 1;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                fi = mid;
                high = mid - 1;
                flag = true;
            }
        }
        if (flag)
            ans.add(fi);
        else
            ans.add((long) -1);

        low = 0;
        high = arr.length - 1;
        long li = -1;

        flag = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x > arr[mid]) {
                low = mid + 1;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                li = mid;
                low = mid + 1;
                flag = true;
            }
        }
        if (flag)
            ans.add(li);
        else
            ans.add((long) -1);

        return ans;
    }
}
