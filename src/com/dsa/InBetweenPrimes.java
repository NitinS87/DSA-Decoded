package com.dsa;

import java.util.Scanner;

public class InBetweenPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        for(int i=low;i<=high;i++){
            boolean flag = false;
            for(int div=2;div<=high/2;div++){
                if(i%div==0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.print(i + ", ");
            }
        }

    }
}
