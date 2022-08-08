package com.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //take the input
        int n = sc.nextInt();
        //initialized a chess board
        List<List<String>> queen =  solveNQueens(n);
        //to print it we print by rows
        int i=1;
        for(List<String> it : queen){
            System.out.println("Arrangement: " + i);
            //for traversal in columns
            for(String s: it){
                System.out.println(s);
            }
            i++;
        }
    }

    private static List<List<String>> solveNQueens(int n) {
        //initialized an empty board and fill it with '.'
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j] = '.';

        //now initialized a new result board which has both the boards
        List<List<String>> result = new ArrayList<>();
        //call to function in which we send our col, new board and end result board
//        solve(0, board, result);
        //leftRow size will be n because we are traversing only in column wise
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2*n-1];
        int[] lowerDiagonal = new int[2*n-1];
        solveOptimized(0, board, leftRow, upperDiagonal, lowerDiagonal, result);
        return result;

    }

    private static void solveOptimized(int col, char[][] board, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, List<List<String>> result) {
        //base case condition
        //when all the columns are traversed board is added to result
        if(col==board.length){
            result.add(construct(board));
            return;
        }

        for(int row=0;row<board.length;row++){
            if(leftRow[row]==0 && lowerDiagonal[row+col] == 0 && upperDiagonal[board.length-1 + col-row]==0){
                board[row][col] = 'Q';
                leftRow[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[board.length-1 + col-row] = 1;
                solveOptimized(col+1, board, leftRow, upperDiagonal, lowerDiagonal, result);
                board[row][col] = '.';
                leftRow[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[board.length-1 + col-row] = 0;
            }
        }
    }

    private static void solve(int col, char[][] board, List<List<String>> result) {
        //base case condition
        //when all the columns are traversed board is added to result
        if(col==board.length){
            result.add(construct(board));
            return;
        }

        for(int row=0;row<board.length;row++){
            if(isPossible(board, row, col)){
                board[row][col] = 'Q';
                solve(col+1, board, result);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isPossible(char[][] board, int row, int col) {
        //only we have to check for the
        //left-side, upper and lower diagonal
        //upper diagonal
        int dupRow = row;
        int dupCol = col;
        while(dupRow>=0 && dupCol>=0){
            if(board[dupRow][dupCol] == 'Q')
                return false;

            dupRow--;
            dupCol--;
        }

        //left side
        dupCol = col;
        while(dupCol>=0){
            if(board[row][dupCol]=='Q')
                return false;

            dupCol--;
        }
        //lower diagonal
        dupRow = row;
        dupCol = col;
        while(dupRow<board.length && dupCol>=0){
            if(board[dupRow][dupCol] == 'Q')
                return false;

            dupRow++;
            dupCol--;
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        //we add the board by making its row as string
        List<String> res = new LinkedList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }
}
