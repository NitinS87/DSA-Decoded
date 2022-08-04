package com.recursion;

import java.util.Scanner;

public class PowerLinearAndLogarithmic {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int ans = power(x, n);
        System.out.println(ans);
        int ansLog = powerLog(x, n);
        System.out.println(ansLog);
    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        int xnm1 = power(x, n-1);
        int xn = x * xnm1;
        return xn;
    }

    public static int powerLog(int x, int n){
        if(n==0){
            return 1;
        }
        int ans = powerLog(x, n/2) * powerLog(x, n/2);
        if(n%2!=0){
            ans = ans*x;
        }
        return ans;
    }
}
