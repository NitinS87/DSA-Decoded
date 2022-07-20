package com.dsa;

import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();

        int freq = getDigitFrequency(n, d);
        System.out.println(freq);
    }

    private static int getDigitFrequency(int n, int d) {
        int freq = 0;
        while(n!=0){
            int rem = n%10;
            if(rem == d)
                freq++;
            n = n/10;
        }

        return freq;
    }
}
