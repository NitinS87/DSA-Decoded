package com.leetcode.array;

import java.util.ArrayList;
import java.util.Scanner;

public class CommonElements3Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] A = new int[n1];
        for (int i = 0; i < n1; i++)
            A[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] B = new int[n2];
        for (int i = 0; i < n2; i++)
            B[i] = sc.nextInt();

        int n3 = sc.nextInt();
        int[] C = new int[n3];
        for (int i = 0; i < n3; i++)
            C[i] = sc.nextInt();

        ArrayList<Integer> ans = findCommonElements(A, B, C, n1, n2, n3);
        System.out.println(ans);
    }

    private static ArrayList<Integer> findCommonElements(int[] a, int[] b, int[] c, int n1, int n2, int n3) {
        ArrayList<Integer> ds = new ArrayList<>();
        int i=0, j=0, k=0;
        while(i<n1 && j<n2 && k<n3){
            if(a[i]==b[j] && b[j]==c[k]) {
                ds.add(a[i]);
                i++;
                j++;
                k++;
            }else if(a[i]<b[j])
                i++;
            else if (b[j]<c[k])
                j++;
            else k++;

            while(i>0 && i<n1 && a[i]==a[i-1])
                i++;
            while (j>0 && j<n2 && b[j]==b[j-1])
                j++;
            while (k>0 && k<n3 && c[k]==c[k-1])
                k++;
        }

        return ds;
    }
}
