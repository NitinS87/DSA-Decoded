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

//        int[] ans;
//        ans = operationArray(arr, r);

        rotateArray(arr, r);
//        display(ans);
        display(arr);
    }

    private static void rotateArray(int[] arr, int r) {
        //mod the r with length of array
        //to convert it in between array length
        r = r% (arr.length);
//        System.out.println(r);

        //the negative r is just equal to r + arr.length
        //as taking one number from front put it to end
        //and taking four numbers from end put them first is same thing
        if(r<0)
            r = r + arr.length;
        //part 1
        //first we reverse the array
        reverse(arr, 0, arr.length-r-1);
        //part 2
        reverse(arr, arr.length-r, arr.length-1);
        //all
        reverse(arr, 0, arr.length-1);
    }

    private static void reverse(int[] arr, int i, int j) {
        int li = i;
        int ri = j;

        while(li<ri){
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;

            li++;
            ri--;
        }
    }


    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }
/*
    private static int[] operationArray(int[] arr, int r) {
        //to get the mod result of r
        r = r% arr.length;
        //take all edge cases
        if(r==0)
            return arr;

        int[] ans = new int[arr.length];

        //taking negative r cases
        if(r<0){
            //convert negative r to positive r
            r = r*-1;
            //reverse the array, rotate it, then again reverse it
            ans = reverseArray(arr);
            ans = rotateArray(ans, r);
            display(ans);
            ans = reverseArray(ans);
            display(ans);
        }else {
            //taking positive r cases
            ans = rotateArray(arr, r);
        }
        return ans;
    }
*/

/*
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
*/
}
