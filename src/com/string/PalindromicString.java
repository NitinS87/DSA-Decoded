package com.string;

import java.util.Scanner;

public class PalindromicString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        solution(s);
    }

    private static void solution(String s) {
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(isPalindrome(s.substring(i,j))){
                    System.out.println(s.substring(i, j));
                }
            }
        }
    }

    private static boolean isPalindrome(String substring) {
        int i=0;
        int j=substring.length()-1;

        while(i<=j){
            char ch1 = substring.charAt(i);
            char ch2 = substring.charAt(j);
            if(ch1!=ch2)
                return false;
            else{
                i++;
                j--;
            }
        }

        return true;
    }
}
