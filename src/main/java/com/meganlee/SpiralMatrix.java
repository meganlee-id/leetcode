package com.meganlee;

import java.util.*;

public class SpiralMatrix {
    //--------------------  Solution 1 -------------------//
    // directions, steps and start point
    public List<Integer> spiralOrder(int[][] matrix) {
        // input validation
        List<Integer> res = new ArrayList();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // {right, down, left, up}
        int[] steps = {matrix[0].length, matrix.length - 1};      // {numCols, numRows-1}
        int go = 0;        // index of directions
        int r = 0, c = -1; // start point
        while (steps[go % 2] != 0) {
            for (int i = 0; i < steps[go % 2]; i++) {
                r += directions[go][0];
                c += directions[go][1];
                res.add(matrix[r][c]);
            }
            steps[go % 2]--;
            go = (go + 1) % 4;
        }
        return res;
    }
    
    //--------------------  Solution  2 -------------------//
    // don't have to deal with 1 row specific
    public List<Integer> spiralOrder2(int[][] matrix) {
        // input checking
        List<Integer> res = new ArrayList();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }

        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for(int i = c1; i <= c2; i++) {
                res.add(matrix[r1][i]);
            }
            r1++;

            for(int i = r1; i <= r2; i++) {
                res.add(matrix[i][c2]);
            }
            c2--;

            for(int i = c2; i >= c1; i--) {
                if (r1 <= r2) {
                    res.add(matrix[r2][i]);
                }
            }
            r2--;
            for(int i = r2; i >= r1; i--) {
                if (c1 <= c2) {
                    res.add(matrix[i][c1]);
                }
            }
            c1++;
        }
        return res;
    }
}
