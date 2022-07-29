package com.recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int f = factorial(n);
        System.out.println(f);
    }

    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        int fact = n*factorial(n-1);
        return fact;
    }
}
