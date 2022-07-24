package com.array;

import java.util.Scanner;

public class ExitPointMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                arr[i][j] = sc.nextInt();
        }

        //in this question
        //we maintain the direction

        int i=0;
        int j=0;
        int dir =0;
        while (true){
            dir = (dir + arr[i][j])%4;

            //east
            if(dir==0){
                j++;
            }
            //south
            else if (dir==1) {
                i++;
            }
            //west
            else if (dir==2) {
                j--;
            }
            //north
            else if(dir==3){
                i--;
            }

            if(i<0){
                i++;
                break;
            } else if (j<0) {
                j++;
                break;
            } else if (i == arr.length) {
                i--;
                break;
            } else if (j == arr[0].length) {
                j--;
                break;
            }

        }
        System.out.println(i);
        System.out.println(j);
    }
}
