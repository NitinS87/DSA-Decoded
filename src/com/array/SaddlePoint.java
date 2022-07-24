package com.array;

import java.util.Scanner;

public class SaddlePoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                arr[i][j] = sc.nextInt();
        }

        //saddle point = the lowest number in a row with the lowest number in the column\
        //first find the lowest number in row
        //then find if it is maximum in column or not
        //if not move to next row
        int row=0;
        int saddle = 0;
        while(row<n){
            //first find the lowest number in row
            int lowestRow = arr[row][0];
            int col=0;
            for(int j=0;j<n;j++){
                if(lowestRow>arr[row][j]){
                    lowestRow=arr[row][j];
                    col=j;
                }
            }
            boolean flag = true;
            //then find if it is maximum in column or not
            for(int i=0;i<n;i++){
                //if not move to next row
                if(lowestRow<arr[i][col]){
                    flag=false;
                    break;
                }
                else{
                    saddle=lowestRow;
                }
            }
            if(flag) {
                System.out.println(saddle);
                return;
            }
            row++;
        }

        System.out.println("Invalid input");
    }
}
