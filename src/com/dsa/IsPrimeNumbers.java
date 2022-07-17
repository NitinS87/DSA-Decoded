package com.dsa;

import java.util.Scanner;

public class IsPrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //testcases
        while (t > 0) {
            int n = sc.nextInt();
            boolean flag = false;
            for(int div=2;div<=n/2;div++){
                if(n%div==0) {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println(n + " is prime");
            }
            else
                System.out.println(n + " is not prime");
            t--;
        }
    }
}
