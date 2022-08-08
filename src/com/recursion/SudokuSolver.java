package com.recursion;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board= {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        solve(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    private static boolean solve(char[][] board) {
        //first traverse the matrix and find empty spaces
        //then check for that empty spaces
        //try out numbers from 0 to 9 and check if same number
        //present in same column, same row and that 3*3 matrix
        //if it is valid update the board and check for next spaces

        //first traverse the matrix and find empty spaces
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //then check for that empty spaces
                if (board[i][j] == '.') {
                    //try out numbers from 0 to 9
                    for (char c = '1'; c <= '9'; c++) {
                        //and check if same number present in
                        //same column, same row and that 3*3 matrix
                        if (isValid(board, i, j, c)) {
                            //if it is valid update the board and check for next spaces
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        //to check validity
        //we will traverse through row, col and that 3*3 matrix,
        //but it will be time-consuming, so we use a trick

        for(int i=0;i<9;i++){
            //for checking row, row is constant but column is changing
            if(board[i][col]==c)
                return false;

            //for checking col, col is constant but row is changing
            if (board[row][i] == c)
                return false;

            //for checking that 3*3 matrix we created a formula
            //to traverse row of that matrix: 3*(row/3) + i/3 = 3*(5/3) + 0%3 = 3 + 0 = 3
            //to traverse col of that matrix: 3*(col/3) + i%3 = 3*(7/3) + 4%3 = 6+1 = 7
            //so pointer will be at board[3][7]
            if(board[3*(row/3) + i/3][3*(col/3) + i%3]==c)
                return false;
        }
        return true;

    }
}
