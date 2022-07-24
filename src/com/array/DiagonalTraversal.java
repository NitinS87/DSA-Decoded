package com.array;

import java.util.Scanner;

public class DiagonalTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                arr[i][j] = sc.nextInt();
        }

        //we found that all diagonals elements have some game in them
        //and last element of a diagonal always ends at last column
        //so loop must start with gap which signifies columns in it
        for(int gap=0;gap< arr.length;gap++){
            for(int i=0, j=gap; j< arr.length;i++,j++){
                System.out.println(arr[i][j]);
            }
        }
    }
}
