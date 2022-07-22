package com.array;

import java.util.Scanner;

public class SpiralTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                arr[i][j] = sc.nextInt();
        }

        int minRow=0;
        int minCol=0;
        int maxCol=m-1;
        int maxRow=n-1;
        int count = 0;
        int totalElements = n*m;
        while(count<totalElements){
            //check counts in every loop as
            //it is not possible that middle block
            //always has all walls
            //left wall
            for(int i=minRow, j=minCol; i<=maxRow && count<totalElements; i++){
                System.out.println(arr[i][j]);
                count++;
            }
            minCol++;

            //bottom wall
            for(int j=minCol,i=maxRow;j<=maxCol && count<totalElements;j++){
                System.out.println(arr[i][j]);
                count++;
            }
            maxRow--;

            //right wall
            for(int i=maxRow, j=maxCol;i>=minRow && count<totalElements;i--){
                System.out.println(arr[i][j]);
                count++;
            }
            maxCol--;
            //top wall
            for(int j=maxCol,i=minRow;j>=minCol && count<totalElements;j--){
                System.out.println(arr[i][j]);
                count++;
            }
            minRow++;
        }
    }
}
