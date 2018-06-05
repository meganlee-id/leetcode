package com.meganlee;

import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // input checking: check if board is 9X9
        // "unit" could be each row/col/cube
        for(int unit = 0; unit < 9; unit++){
            Set<Character> rows  = new HashSet();
            Set<Character> cols  = new HashSet();
            Set<Character> cubes = new HashSet();
            // in each unit, we check cell uniq
            for (int i = 0; i < 9; i++){
                // unit == row, check no dupes in col
                if(board[unit][i]!='.' && !rows.add(board[unit][i]))
                    return false;
                // unit == col, check no dupes in ro
                if(board[i][unit]!='.' && !cols.add(board[i][unit]))
                    return false;
                // unit == cube, check no dupes in square
                int r = (unit / 3) * 3 + (i / 3); // r0 = (unit / 3) * 3, rOffset = i / 3
                int c = (unit % 3) * 3 + (i % 3); // c0 = (unit % 3) * 3, cOffset = i % 3
                if(board[r][c] !='.' && !cubes.add(board[r][c]))
                    return false;
            }
        }
        return true;
    }
}