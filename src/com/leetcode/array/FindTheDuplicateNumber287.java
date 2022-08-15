package com.leetcode.array;

import java.util.Scanner;

public class FindTheDuplicateNumber287 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(findDuplicateBrute(arr));
        System.out.println(findDuplicateBetter(arr));
        System.out.println(findDuplicateOptimal1(arr));
//        System.out.println(findDuplicateOptimal2(arr));
    }

    private static int findDuplicateOptimal2(int[] arr) {
        //not for all solutions
        int ans=0;

        //first for loop, we apply XOR to every element in array
        //we know similar elements XOR is 0 : a^a=0
        //and odd ones result in 1
        //5^1 = 5
        //5^0 = 1
        System.out.println("1st for loop: " );
        for(int i=0;i<arr.length;i++) {
            ans = ans ^ arr[i];
            System.out.print(ans +" ");
        }


        System.out.println("2nd for loop: ");
        //now we know that elements are in range of 1 to n-1
        //so we XOR them and if
        for(int i=1;i<arr.length;i++) {
            ans = ans ^ i;
            System.out.print(ans + " ");
        }

        return ans;

    }

    private static int findDuplicateOptimal1(int[] arr) {
        //slow pointer fast pointer linked list approach
        //we increment slow with 1 and fast with 2 until they both are equal
        //after that fast becomes arr[0] and then increment slow and fast by 1
        //till they gets equal
        int fast = arr[0];
        int slow = arr[0];

        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while (slow!=fast);

        fast = arr[0];
        while(slow!=fast){
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }

    private static int findDuplicateBetter(int[] arr) {
        //if we know that these elements lies in between 1-n
        //then make a new count array and count the number of times
        //an element occur and then return elements having more than one count
        int[] count = new int[arr.length+1];
        for(int i: count)
            i = 0;

        for (int j : arr) {
            if (count[j] == 1)
                return j;
            else count[j] = 1;
        }

        return -1;

        //this algorithm has time complexity of O(n)
        //and space complexity of O(n)
    }

    public static int findDuplicateBrute(int[] arr) {
        int duplicate = 0;
        //simple take two pointers current(i) and comparator(j)
        //we will compare current element with comparator and
        //if elements are equal we return that element
        for (int i=0;i< arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]==arr[j])
                    return arr[i];
            }
        }
        return duplicate;

        //this algorithm has time complexity of O(n^2)
        //and space complexity of O(1)
    }
}
