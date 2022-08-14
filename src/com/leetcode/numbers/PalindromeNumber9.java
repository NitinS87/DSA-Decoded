package com.leetcode.numbers;

import java.util.Scanner;

public class PalindromeNumber9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPalindromeString(n));
        System.out.println(isPalindrome(n));
    }

    private static boolean isPalindrome(int n) {
        if(n<0)
            return false;
        System.out.println(n);
        int orgN = n;
        int rev = 0;
        while(n!=0){
            int rem = n%10;
            rev = rev*10 + rem;
            n = n/10;
        }
        System.out.println(rev);
        return orgN == rev;
    }

    public static boolean isPalindromeString(int x) {
        String s = String.valueOf(x);
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }


}
