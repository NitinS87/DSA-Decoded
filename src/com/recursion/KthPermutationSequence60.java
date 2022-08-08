package com.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KthPermutationSequence60 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(getPermutations(n,k));
    }

    private static String getPermutations(int n, int k) {
        //find the factorial of n-1
        //add numbers in the list
        //reduce k by 1
        //check at which iteration we will get desired k
        //by boiling the question
        //divide the permutations in block and check at which block
        //we will get desired result
        //update the block by dividing remaining factorial permutations

        //initialize a list
        List<Integer> list = new ArrayList<>();
        //find the factorial of n-1
        int fact=1;
        for(int i=1;i<n;i++){
            fact = fact*i;
            //add numbers in the list
            list.add(i);
        }
        //reduce k by 1
        list.add(n);
        String ans="";
        k = k-1;
        //check at which iteration we will get desired k
        while (true){
            ans = ans + list.get(k/fact);
            list.remove(k/fact);
            if(list.size()==0)
                break;

            k = k%fact;
            fact = fact/list.size();
        }

        return ans;
    }
}
