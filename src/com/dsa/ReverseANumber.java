package com.dsa;

import java.util.Scanner;

public class ReverseANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //testcases
        while (t > 0) {
            int n = sc.nextInt();
            int reversed=0;
            while(n!=0){
                int dig = n%10;
                System.out.println(dig);
                reversed= reversed*10 + dig;
                n=n/10;
            }
            System.out.println(reversed);
            t--;
        }
    }
}
