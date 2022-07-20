package com.array;

import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int r = sc.nextInt();

        int[] ans;
        ans = operationArray(arr, r);

        display(ans);
    }

    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }

    private static int[] operationArray(int[] arr, int r) {

        //take all edge cases
        if(r==0)
            return arr;

        int[] ans = new int[arr.length];
        //to get the mod result of r
        r = r% arr.length;

        //taking negative r cases
        if(r<0){
            //convert negative r to positive r
            r = r*-1;
            //reverse the array, rotate it, then again reverse it
            ans = reverseArray(arr);
            ans = rotateArray(ans, r);
            ans = reverseArray(ans);
        }

        //taking positive r cases
        if(r>0){
            ans = rotateArray(arr, r);
        }

        return ans;
    }

    private static int[] rotateArray(int[] arr, int r) {
        //create a new array
        int[] rotArr = new int[arr.length];
        //take the desired rotated elements from original array
        int k = arr.length-r;
        int j = 0;
        for(int i=k;i< rotArr.length;i++){
            //assigned them to new arr
            rotArr[j++] = arr[i];
        }//assign rest elements after rotated elements
        for(int i=0;i<k;i++){
            rotArr[j++] = arr[i];
        }

        return rotArr;
    }

    private static int[] reverseArray(int[] arr) {
        int[] revArr = new int[arr.length];

        int c = arr.length-1;
        for(int i=0;i< arr.length;i++){
            revArr[i] = arr[c--];
        }

        return revArr;
    }
}
