package com.recursion;

import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {

        int n = 4;
        int[][] arr = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};

//        ArrayList< String > res = findPath(a, n);
        ArrayList< String > res = findPathOptimized(arr, n);
        if (res.size() > 0) {
            for (String re : res) System.out.print(re + " ");
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

    private static ArrayList<String> findPathOptimized(int[][] arr, int n) {
        int[][] vis = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                vis[i][j]=0;

        int[] di = {+1, 0, 0, -1};
        int[] dj = {0, -1, +1, 0};

        ArrayList<String> ans = new ArrayList<>();
        if(arr[0][0] == 1)
            solveOptimized(0, 0, arr, vis, ans, "", di, dj);

        return ans;
    }

    private static void solveOptimized(int i, int j, int[][] arr, int[][] vis, ArrayList<String> ans, String move, int[] di, int[] dj) {
        if(i== arr.length-1 && j== arr[0].length-1){
            ans.add(move);
            return;
        }

        String dir = "DLRU";
        for(int ind = 0; ind<4;ind++){
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            //do all boundary checks then check for visited or not and at last if next index is 1
            if (nexti >= 0 && nextj >= 0 && nexti < arr.length && nextj < arr[0].length &&
                    vis[nexti][nextj] == 0 && arr[nexti][nextj] == 1) {

                vis[i][j] = 1;
                solveOptimized(nexti, nextj, arr, vis, ans, move+dir.charAt(ind), di, dj);
                vis[i][j] = 0;
            }
        }
    }

    private static ArrayList<String> findPath(int[][] arr, int n) {
        int[][] vis = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                vis[i][j]=0;

        ArrayList<String> ans = new ArrayList<>();
        if(arr[0][0] == 1)
            solve(0, 0, arr, vis, ans, "");

        return ans;
    }

    private static void solve(int i, int j, int[][] arr, int[][] vis, ArrayList<String> ans, String move) {
        if(i== arr.length-1 && j== arr[0].length-1){
            ans.add(move);
            return;
        }

        //downward
        if(i+1< arr.length && vis[i+1][j]==0 && arr[i+1][j]==1){
            vis[i][j] = 1;
            solve(i+1, j, arr, vis, ans, move+"D");
            vis[i][j] = 0;
        }

        //left
        if(j-1>=0 && vis[i][j-1]==0 && arr[i][j-1]==1){
            vis[i][j] = 1;
            solve(i, j-1, arr, vis, ans, move+"L");
            vis[i][j] = 0;
        }

        //right
        if(j+1< arr[0].length && vis[i][j+1]==0 && arr[i][j+1]==1){
            vis[i][j] = 1;
            solve(i, j+1, arr, vis, ans, move+"R");
            vis[i][j] = 0;
        }

        //upward
        if(i-1>=0 && vis[i-1][j]==0 && arr[i-1][j]==1){
            vis[i][j] = 1;
            solve(i-1, j, arr, vis, ans, move+"U");
            vis[i][j] = 0;
        }
    }
}
