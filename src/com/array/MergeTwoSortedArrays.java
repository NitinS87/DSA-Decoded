package com.array;

import java.util.Scanner;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++)
            arr1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int n = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++)
            arr2[i] = sc.nextInt();

        mergeBrute(arr1, arr2);
        mergeOptimal1(arr1, m, arr2, n);

        for(int i: arr1)
            System.out.print(i + " ");
    }
    private static void mergeOptimal1(int[] nums1, int m, int[] nums2, int n) {
        //start from last index of greater element of array and update in arr1
        //then decrement those arrays

        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2, if any
            nums1[finished--] = nums2[tail2--];
        }
    }

    private static void mergeBrute(int[] arr1, int[] arr2) {
        //take the smaller array and compare it with first element of larger array
        //then put it in the desired place
        int[] mergedArr = new int[arr1.length+ arr2.length];
        int count=0;
        int p1 =0 , p2 = 0;
        while(count< mergedArr.length){
            if(p1!= arr1.length && p2!=arr2.length && arr1[p1]<arr2[p2])
                mergedArr[count++] = arr1[p1++];
            else
                mergedArr[count++] = arr2[p2++];
        }

        for(int i: mergedArr)
            System.out.print(i +" ");

        //this method take space complexity of O(N)
        //and time complexity of O(n+m);
    }
}
