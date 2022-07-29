package com.recursion;

import java.util.Scanner;

public class PrintIncreasingDecreasing {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pdi(n);
    }

    public static void pdi(int n){
        if(n==0){
            return;
        }
        //this will write decreasing
        System.out.println(n);
        pdi(n-1);
        //until n becomes zero 1 and 2 line executes only
        //after that backtracking starts and next statements starts executing
        //after that line 3 starts and print n
        System.out.println(n);

    }
}
