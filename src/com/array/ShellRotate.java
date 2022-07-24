package com.array;

import java.util.Scanner;

public class ShellRotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int shell = sc.nextInt();
        int r = sc.nextInt();
        rotateShell(arr, shell, r);
        display(arr);
    }

    private static void rotateShell(int[][] arr, int shell, int r) {
        //first take the elements of shell separately
        int[] oneD = fillOnedFromShell(arr, shell);
        //rotate them using rotate method from oneD
        rotate(oneD, r);
        //fill that shell again with those elements
        fillShellFromOned(arr, oneD, shell);
    }

    private static int[] fillOnedFromShell(int[][] arr, int shell) {
        int minRow = shell-1;
        int minCol = shell-1;
        int maxRow = arr.length-shell;
        int maxCol = arr[0].length-shell;
        int size = 2*(maxRow-minRow+maxCol-minCol); //left_wall+bottom_wall+right_wall+top_wall-4
        int[] oneD = new int[size];

        int index=0;
        //lw
        for(int i=minRow, j=minCol; i<=maxRow;i++){
            oneD[index++] = arr[i][j];
        }minCol++;
        //bw
        for(int i=maxRow, j=minCol; j<=maxCol;j++){
            oneD[index++] = arr[i][j];
        }maxRow--;
        //rw
        for(int i=maxRow, j=maxCol; i>=minRow;i--){
            oneD[index++] = arr[i][j];
        }maxCol--;
        //tw
        for(int i=minRow, j=maxCol; j>=minCol;j--){
            oneD[index++] = arr[i][j];
        }
        minRow++;
        return oneD;
    }
    private static void rotate(int[] oneD, int r) {
        r=r% oneD.length;
        if(r<0)
            r=r+ oneD.length;
        reverse(oneD, 0, oneD.length-r-1);
        reverse(oneD, oneD.length-r, oneD.length-1);
        reverse(oneD, 0, oneD.length-1);
    }

    private static void reverse(int[] oneD, int li, int ri) {

        while(li<ri){
            int temp = oneD[li];
            oneD[li] = oneD[ri];
            oneD[ri] = temp;

            li++;
            ri--;
        }
    }

    private static void fillShellFromOned(int[][] arr, int[] oneD, int shell) {
        int index=0;
        int minRow = shell-1;
        int minCol = shell-1;
        int maxRow = arr.length-shell;
        int maxCol = arr[0].length-shell;
        //lw
        for(int i=minRow, j=minCol; i<=maxRow;i++){
            arr[i][j]=oneD[index++];
        }minCol++;
        //bw
        for(int i=maxRow, j=minCol; j<=maxCol;j++){
            arr[i][j]=oneD[index++];
        }maxRow--;
        //rw
        for(int i=maxRow, j=maxCol; i>=minRow;i--){
            arr[i][j]=oneD[index++];
        }maxCol--;
        //tw
        for(int i=minRow, j=maxCol; j>=minCol;j--){
            arr[i][j]=oneD[index++];
        }minRow++;
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
