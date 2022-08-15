package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AlternatingNegAndPos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[] mix = alterBrute(arr);
        System.out.println(Arrays.toString(mix));
        alterOutOfPlace(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void alterOutOfPlace(int[] arr) {
        int lastNegative = 1;
        int lastPositive = 0;
        //idea is to store last correct place of positive and negative element in array
        //then swap the incorrect place elements after correct place elements
        for(int i=0;i< arr.length && lastPositive<arr.length && lastNegative< arr.length; i++){
            if(arr[i]>0){
                int temp = arr[i];
                arr[i] = arr[lastPositive];
                arr[lastPositive] = temp;
                lastPositive += 2;
            }
            if(arr[i]<0){
                int temp = arr[i];
                arr[i] = arr[lastNegative];
                arr[lastNegative] = temp;
                lastNegative += 2;
            }
        }

    }

    private static int[] alterBrute(int[] arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> negs = new ArrayList<>();
        for (int i : arr) {
            if (i < 0)
                negs.add(i);
            else
                pos.add(i);
        }

        int negCount = 0;
        int posCount = 0;

        boolean odd = arr.length % 2 != 0;

        int[] mix = new int[arr.length];
        int mixCount = mix.length;
        if(odd)
            mixCount = mix.length-1;
        for(int i=0;i< mixCount;i=i+2){
            if(negCount<negs.size())
                mix[i] = negs.get(negCount++);
            if(posCount<pos.size())
                mix[i+1] = pos.get(posCount++);
        }
        if(odd){
            if(negCount<negs.size())
                mix[mixCount] = negs.get(negCount);
            if(posCount<pos.size())
                mix[mixCount] = pos.get(posCount);
        }

        return mix;

    }
}
