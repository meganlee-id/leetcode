package com.meganlee;

import java.util.*;

public class SetMatrixZeros {
    //------------------ Solution ----------------------//
    // S=O(M+N)
    public void setZeroes(int[][] matrix) {
        // check matrix is a M X N rectangle
        // input validation
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        
        int M = matrix.length, N = matrix[0].length;
        // set the flags
        boolean[] rowFlag = new boolean[M]; // a vertical flag array,   indicate each row
        boolean[] colFlag = new boolean[N]; // a horizontal flga array, indicate each col
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (matrix[r][c] == 0) {
                    rowFlag[r] = true;
                    colFlag[c] = true;
                }
            }
        }
        
        // set matrix zero
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (rowFlag[r] || colFlag[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }


    //------------------ Solution ----------------------//
    public void setZeroes2(int[][] matrix) {
        // check matrix is a M X N rectangle
        // input validation
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        // step 1: set clear flags
        boolean clearFirstRow = false, clearFirstCol = false;
        int M = matrix.length, N = matrix[0].length;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (matrix[r][c] == 0) {
                    if (r == 0) {
                        clearFirstRow = true;
                    }
                    if (c == 0) {
                        clearFirstCol = true;
                    }
                    matrix[0][c] = 0; // set 1st row flag 
                    matrix[r][0] = 0; // set 1st col flag
                }
            }
        }
        // step 2: clear matrix using 1st row/col 
        for (int r = 1; r < M; r++) {      // start from 1
            for (int c = 1; c < N; c++) {  // start from 1
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        // step 3: clear 1st row/col 
        if (clearFirstRow) {
            for(int c = 0; c < N; c++) {
                matrix[0][c] = 0;
            }
        }
        if (clearFirstCol) {
            for(int r = 0; r < M; r++) {
                matrix[r][0] = 0;
            }
        } 
    }
}
