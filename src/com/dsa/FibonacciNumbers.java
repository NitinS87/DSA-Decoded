package com.dsa;

import java.util.Scanner;

public class FibonacciNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f1=0;
        int f2 = 1;
        for(int i=0;i<n;i++){
            System.out.println(f1);
            int next = f1+f2;
            f1=f2;
            f2=next;
        }
    }
}
