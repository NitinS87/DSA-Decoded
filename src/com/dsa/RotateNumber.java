package com.dsa;

import java.util.Scanner;

public class RotateNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int rotN;
        int count = countDigits(n);
        k = k%count;

        if(k==count || k==0)
            rotN = n;

        else{
            if(k<0)
                k=k+count;
            rotN = rotateNumber(n, k, count);
        }

        System.out.println(rotN);
    }

    static int rotateNumber(int n, int k, int count) {
        int rem;
        int rotN;
        int div = (int) Math.pow(10, k);
        rem = n%div;
        n=n/div;

        rotN = n + rem*((int) Math.pow(10, count-k));
        return rotN;
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
