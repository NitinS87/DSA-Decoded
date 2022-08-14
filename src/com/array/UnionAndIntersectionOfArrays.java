package com.array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionAndIntersectionOfArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for(int i=0;i<n1;i++)
            arr1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i=0;i<n2;i++)
            arr2[i] = sc.nextInt();
        
        solve(arr1, arr2);
    }

    private static void solve(int[] arr1, int[] arr2) {
        //using Hashset
        //just create a hashset containing all elements from both arrays
        //and other contains only common elements
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i : arr1) {
            set.add(i);
        }
        for (int i : arr2) {
            if (set.contains(i)) {
                intersect.add(i);
            }
            set.add(i);
        }

        System.out.println("Union of arrays: " + set);
        System.out.println("Intersect of arrays: " + intersect);
    }
}
