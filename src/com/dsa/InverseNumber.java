package com.dsa;

import java.util.Scanner;

public class InverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n<0)
            n = n*-1;

        if(validity(n)){
            int inv = 0;    //inverted number
            int op=1;       //original place
            while(n!=0){
                int od = n%10;   //original digit
                int id = op;     //inverted digit

                inv = inv + id * (int)Math.pow(10, od -1);

                op++;
                n = n/10;
            }
            System.out.println(inv);
        }

    }
    static boolean validity(int n) {
        int x = n;
        int count = 0;
        int nSum = 0;
        while(x!=0){
            int rem = x%10;
            nSum += rem;
            count++;
            x = x/10;
        }
        int oSum = 0;
        for(int i=1;i<=count;i++){
            oSum += i;
        }

        return oSum == nSum;
    }
}
