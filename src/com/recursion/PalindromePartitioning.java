package com.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        palindromePartitioning(s);
    }

    private static void palindromePartitioning(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        //recursive function
        solve(0, s, path, res);
        System.out.println(res);
    }

    private static void solve(int index, String s, List<String> path, List<List<String>> res) {
        //base case condition
        if(index==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        //first we will traverse through the string from index
        //then check if that part of string is palindrome or not
        //if it is palindrome add it to path
        //to check all solutions we will use backtracking and remove the last path
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                solve(i+1, s,path, res);
                path.remove(path.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }

        return true;
    }


}
