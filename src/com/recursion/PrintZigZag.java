package com.recursion;

import java.util.Scanner;

//Ques: Input2 -> 2
//      Output2 -> 2 1 1 1 2 1 1 1 2
public class PrintZigZag {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pzz(n);
    }

    private static void pzz(int n) {
        if(n==0)
            return;

        //Pre
        System.out.println(n + " ");
        pzz(n-1);
        //In
        System.out.println(n + " ");
        pzz(n-1);
        //Post
        System.out.println(n + " ");
    }
}
