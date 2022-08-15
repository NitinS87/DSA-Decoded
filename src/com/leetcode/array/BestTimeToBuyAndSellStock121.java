package com.leetcode.array;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock121 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(maxProfitNaive(arr));
        System.out.println(maxProfitOptimal(arr));
    }

    private static int maxProfitOptimal(int[] arr) {
        /*int lsf = Integer.MAX_VALUE; // least so far
        int op = 0; // overall profit
        int pist = 0; // profit if sold today

        for (int i : arr) {
            if (i < lsf) { // if we found new buy value which is smaller than previous one
                lsf = i; // update our least so far
            }
            pist = i - lsf; // calculating profit if sold today by, Buy - sell
            if (op < pist) { // if pist is more than our previous overall profit
                op = pist; // update overall profit
            }
        }
        return op; // return op

        */

        //-------------------------OR---------------------------------------------------


        int buy=Integer.MAX_VALUE,sell=0;
        for (int i : arr) {
            buy = Math.min(buy, i);
            sell = Math.max(sell, i - buy);
        }
        return sell;
    }

    private static int maxProfitNaive(int[] arr) {
        //first find the lowest buying day
        //second find the highest selling day after buying day
        //return second-first

        int profit = 0;
        //first find the lowest buying day
        for(int lowest=0;lowest<= arr.length-2;lowest++){
            //second find the highest selling day after buying day
            for(int highest=lowest+1;highest< arr.length;highest++){
                //find current profit
                int temp = arr[highest]-arr[lowest];
                if(temp > profit)
                    profit=temp;
            }
        }
        return profit;
    }
}
