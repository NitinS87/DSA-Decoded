package com.array;

import java.util.Scanner;

public class MinAndMax {
    static class Pair{
        int min;
        int max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        Pair pair = getMinMax(arr,n);
        System.out.println(pair.min);
        System.out.println(pair.max);
    }

    private static Pair getMinMax(int[] arr, int n) {
        Pair minAndMax = new Pair();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        //if the array has odd number of elements then ignore the last
        //element and consider it later
        boolean odd = (n & 1) == 1;
        if(n%2!=0)
            n--;

        for(int i=0;i<n;i=i+2){
            int maximum, minimum;

            //find maximum and minimum among nums[i] and nums[i+1]
            if(arr[i]>arr[i+1]){
                //update min
                if(arr[i+1]<min)
                    min = arr[i+1];
                //update max
                if(arr[i]>max)
                    max = arr[i];
            }
            else {
                //update min
                if(arr[i]<min)
                    min = arr[i];
                //update max
                if(arr[i+1]>max)
                    max = arr[i+1];
            }

        }

        if(odd){
            if(arr[n] > max)
                max=arr[n];
            if(arr[n]<min)
                min=arr[n];
        }

        minAndMax.max = max;
        minAndMax.min = min;

        return minAndMax;
    }
}
