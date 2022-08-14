package com.leetcode.array;

import java.util.Scanner;

public class MinimumJumps45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int idx = Math.abs(arr[0]);
        System.out.println(minimumJumps(arr));
    }

    private static int minimumJumps(int[] arr) {
        //to find minimum number of jumps just loop through the array
        //take current position and maximum destination we can reach from that index
        //then update max destination if larger dest is given
        int jumps=0;
        int pos=0;
        int dest=0;
        if(arr[0]==0)
            return -1;
        if(arr.length==1)
            return 0;
        for(int i=0;i< arr.length-1;i++){
            dest = Math.max(dest, arr[i]+i);

            if(pos==i){
                pos=dest;
                jumps++;
            }
            if(i>=dest)
                return -1;
        }

        return jumps;

    }
}
