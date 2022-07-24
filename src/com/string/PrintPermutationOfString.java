package com.string;

import java.util.Scanner;

public class PrintPermutationOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        solution(s);
    }

    public static void solution(String s){
        int n = s.length();
        int f = factorial(n);

        for(int i=0;i<f;i++){
            StringBuilder sb = new StringBuilder(s);
            int temp=i;

            for(int div=n;div>=1;div--){
                int q = temp/div;
                int rem = temp%div;

                System.out.print(sb.charAt(rem));
                sb.deleteCharAt(rem);

                temp = q;
            }
            System.out.println();
        }
    }

    private static int factorial(int n) {
        int prod=1;
        for(int i=2;i<=n;i++){
            prod *= i;
        }

        return prod;
    }
}
