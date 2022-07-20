package com.dsa;

import java.util.Scanner;

public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//source number
        int b = sc.nextInt();//source base
        int destB = sc.nextInt();//destination base

        int decN = anyBaseToDecimal(n, b);
        int baseN = decimalToAnyBase(decN, destB);
        System.out.println(baseN);

    }

    private static int decimalToAnyBase(int decN, int destB) {
        //to convert decimal number to any base
        int baseN = 0;
        int p = 1;

        while(decN>0){
            //divide it with the desired base
            int rem = decN%destB;
            decN = decN/destB;

            //and line those remainders in down to up format
            baseN += rem*p;
            p = p*10;
        }

        return baseN;
    }

    private static int anyBaseToDecimal(int n, int b) {
        //to covert any base to decimal
        int bd = 0;
        int p = 0;
        while(n>0){
            //divide the number with 10
            int rem = n%10;
            n = n/10;

            //then multiply the remainders with power of base
            //at last add all of them
            bd += rem*(Math.pow(b, p));
            p++;
        }

        return bd;
    }
}
