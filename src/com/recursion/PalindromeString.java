package com.recursion;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(isPalindrome(0,s));
    }
    public static boolean isPalindrome(int i,String s){

        //base case
        if(i >= s.length()/2)
            return true;
        //false condition
        if(s.charAt(i) != s.charAt(s.length()-i-1))
            return false;
        //recursive call
        return isPalindrome(i+1, s);
    }
}
