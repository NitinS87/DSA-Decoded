package com.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class RemovePrimes {
    public static void solution(ArrayList<Integer> al){
        // write your code here
        //first we will traverse through arraylist
        //check if current number is prime or not
        //remove if it is prime

        //first we will traverse through arraylist
        //we start the loop from backwards because
        //during removal the index of elements changes so some elements left unchanged
        //as i start from next index in loop
        for(int i= al.size()-1;i>= 0;i--){
            //check if current number is prime or not
            if(!isPrime(al.get(i))){
                //remove if it is prime
                al.remove(i);
            }
        }

    }

    //prime numbers function
    private static boolean isPrime(Integer n) {
        boolean flag=false;
        for(int i=2;i<=n/2;i++){
            if(n%i==0) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);
    }
}
