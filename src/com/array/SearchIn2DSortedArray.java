package com.array;

import java.util.Scanner;

public class SearchIn2DSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                arr[i][j] = sc.nextInt();
        }

        int x = sc.nextInt();
        search(arr,x);
    }

    private static void search(int[][] arr, int x) {
        int i=0;
        int j=arr[0].length-1;

        while (i< arr.length && j>=0){
            if(x == arr[i][j]){
                System.out.println(i);
                System.out.println(j);
                return;
            } else if (arr[i][j]>x) {
                j--;
            }
            else {
                i++;
            }
        }

        System.out.println("Not Found");
    }
}
