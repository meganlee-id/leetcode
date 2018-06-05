package com.meganlee;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        // assume that board is 9X9 and char is only '.' or '1' ~ '9'
        helper(board, 0);
    }
    
    private boolean helper(char[][] board, int n) {
        // base case, 0 <= n <= 80
        if (n == 81) {
            return true;    // use a boolean to stop with 1st solution
        }
        // general case
        int row = n / 9, col = n % 9;
        // already has a num, move on
        if (board[row][col] != '.') {
            return helper(board, n + 1);
        // to be filled with num
        } else {
            for (int num = 1; num <= 9; num++) {
                board[row][col] = (char)(num + '0'); // type cast
                if (valid(board, row, col) && helper(board, n + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
            return false;
        }
    }

    // check if the cur num at (row, col) will break validity (might still be "." on board)
    // this is called after we fill the cell (row, col) with a NUMBER (no "." at cur pos)
    private boolean valid(char[][] board, int row, int col) {
        int curNum = board[row][col];
        for (int i = 0; i < 9; i++) {
            int r = (row / 3) * 3 + (i / 3); // row offset within square
            int c = (col / 3) * 3 + (i % 3); // col offset within square
            if ((i != row && curNum == board[i][col]) ||  // fix col, check each row
                (i != col && curNum == board[row][i]) ||  // fix row, check each col
                ((r != row || c != col) && curNum == board[r][c])) {  // fix square, check each pos
                return false;
            }
        }
        return true;
    }
}

