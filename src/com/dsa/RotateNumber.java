package com.dsa;

import java.util.Scanner;

public class RotateNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int rotN = 0;
        int count = countDigits(n);
        k = k%count;

        if(k==count)
            rotN = n;
        if(k>0)
            rotN = rotateNumber(n, k, count);
        if(k<0){
            k = k*-1;
            int rev = reverseNumber(n);
            rev = rotateNumber(rev, k, count);
            rotN = reverseNumber(rev);
        }

        System.out.println(rotN);
    }

    static int rotateNumber(int n, int k, int count) {
        int rem;
        int rotN;
        int div = (int) Math.pow(10, k);
        rem = n%div;
        n=n/div;


        rotN = n + rem*(int) Math.pow(10, count-k);
        return rotN;
    }

    static int reverseNumber(int n) {
        int rev = 0;
        while(n!=0){
            rev = rev*10 + n%10;
            n = n%10;
        }
        return rev;
    }

    static int countDigits(int n) {
        int count = 0;
        int k = n;
        while(k!=0){
            k = k/10;
            count++;
        }
        return count;
    }
}
