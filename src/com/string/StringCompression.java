package com.string;

import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(compression1(s));
        System.out.println(compression2(s));
    }

    private static String compression1(String s) {
        StringBuilder str = new StringBuilder(s.charAt(0) + "");
        for(int i=1;i<s.length();i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);

            if(curr != prev){
                str.append(curr);
            }
        }

        return str.toString();
    }

    private static String compression2(String s) {
        StringBuilder str = new StringBuilder(s.charAt(0) + "");
        int count=1;
        for(int i=1;i<s.length();i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);

            if(curr == prev){
                count++;
            }
            else{
                if(count>1){
                    str.append(count);
                    count = 1;
                }
                str.append(curr);

            }
        }

        if(count>1){
            str.append(count);
        }

        return str.toString();
    }
}
