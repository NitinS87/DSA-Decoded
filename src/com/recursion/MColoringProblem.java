package com.recursion;

import java.util.List;
import java.util.Scanner;

public class MColoringProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    //given a graph, color arrays, starting node, and m is no of max colors use
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m){
        int n = G.length;
        return solve(i, G, color, n, m);
    }

    private static boolean solve(int node, List<Integer>[] G, int[] color, int n, int m) {
        //base case
        //when all the nodes are traversed
        if(node == n)
            return true;

        //loop through the array of colors till the maximum colors reached
        //if before reaching the last node, our colors ended return false
        for(int i=1;i<=m;i++){
            //if coloring the node is safe
            //color it and check for the next node
            //if the next node returns false remove the color in it
            if(isSafe(node, G, color, n, i)){
                color[node] = i;
                if(solve(node+1, G, color, n, m))
                    return true;
                color[node] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int node, List<Integer>[] G, int[] color, int n, int col) {
        //traverse at the adjacent nodes
        //and compare the colors on them
        //if they are same return false else true
        for(int it: G[node]){
            if(color[it] == col)
                return false;
        }

        return true;
    }

}
