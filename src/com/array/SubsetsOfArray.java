package com.array;

import java.util.Scanner;

public class SubsetsOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        //subsets are in binary number from 0 to n
        int limit = (int)Math.pow(2,n);
        for(int i=0;i<limit;i++){
            String set = "";
            int temp = i;
            //we start j from end as it will print the number from starting
            //like if we divide 6 with 2 it will give 0 at first
            //which is the last digit of binary number not first
            for(int j= arr.length-1; j>=0; j--){
                //convert i's into binary number
                int r = temp%2;
                temp=temp/2;
                if(r==0)
                    set = "-\t" + set;
                else
                    set = arr[j] + "\t" + set;
            }
            System.out.println(set);
        }

    }
}
