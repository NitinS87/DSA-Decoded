package com.dsa;

import java.util.Scanner;

public class GCDandLCM {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int on1 = n1;
        int on2 = n2;

        int gcd = 0;
        if(n1>n2){
            while (n1%n2!=0){
                int rem = n1%n2;
                n1=n2;
                n2=rem;
                gcd = n2;
            }
        }
        else{
            while (n2%n1!=0){
                int rem = n2%n1;
                n2=n1;
                n1=rem;
                gcd = n1;
            }
        }

        
        int lcm = (on1*on2)/gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}
