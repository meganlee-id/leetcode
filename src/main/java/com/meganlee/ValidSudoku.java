package com.meganlee;

import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // input checking: check if board is 9X9
        // 1. check row by row
        for (int r = 0; r < 9; r++) {
            Set<Character> row = new HashSet();
            for(int c = 0; c < 9; c++) {
                if (board[r][c] != '.' && !row.add(board[r][c])) {
                    return false;
                }
            }
        }
        // 2. check col by col
        for (int c = 0; c < 9; c++) {
            Set<Character> col = new HashSet();
            for(int r = 0; r < 9; r++) {
                if (board[r][c] != '.' && !col.add(board[r][c])) {
                    return false;
                }
            }
        }
        // 3. check each square
        for (int i = 0; i < 9; i++) { // i indicates which block we r looking ats
            Set<Character> block = new HashSet();
            int rowStart = (i / 3) * 3;
            int colStart = (i % 3) * 3;
            for (int r = rowStart; r < rowStart + 3; r++) {
                for (int c = colStart; c < colStart + 3; c++) {
                    if (board[r][c] != '.' && !block.add(board[r][c])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}