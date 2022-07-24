package com.array;

import java.util.Scanner;

public class Rotate90Degree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
//        arr = rotate90(arr);
        //or what we can do is transpose the arr
        //then reverse it

        //transpose
        for(int i=0;i< arr.length;i++){
            for(int j=i;j< arr[0].length;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //reverse
        for(int i=0;i< arr.length;i++){
            int li=0;
            int ri= arr[i].length-1;

            while (li<ri){
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;

                li++;
                ri--;
            }
        }
        display(arr);

    }

    private static int[][] rotate90(int[][] arr) {
        int[][] rotArr = new int[arr.length][arr[0].length];
        int x=0, y= arr[0].length-1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                rotArr[x][y] = arr[i][j];
                x++;
            }
            y--;
            x=0;
        }
        return rotArr;
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
