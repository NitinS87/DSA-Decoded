package com.array;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizeTheHeights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int diff = minimizeHeights(arr, k);
        System.out.println(diff);
    }

    private static int minimizeHeights(int[] arr, int k) {
        if(arr.length==1)
            return 0;

        Arrays.sort(arr);
        // Maximum possible height difference
        int ans = arr[arr.length - 1] - arr[0];

        int min, max;
        for (int i = 1; i < arr.length; i++) {
            // if on subtracting k we got negative then
            // continue
            if (arr[i] - k < 0)
                continue;

            //idea is to make all middle elements minimum by subtracting k
            // Minimum element when we add k to whole array
            min = Math.min(arr[0] + k, arr[i] - k);
            //Maximum element when we subtract k from whole array
            //idea is to make all middle elements maximum by adding k
            max = Math.max(arr[i - 1] + k, arr[arr.length - 1] - k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}
