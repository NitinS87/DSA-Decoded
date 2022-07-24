package com.string;

import java.util.Scanner;

public class DifferenceInCharSize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(toDiffString(s));
    }

    private static String toDiffString(String s) {
        String diffString = s.charAt(0) + "";
        for(int i=1;i<s.length();i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);

            int diff = curr-prev;
            diffString = diffString + diff + curr;
        }

        return diffString;
    }
}
