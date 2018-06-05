package com.meganlee;

import java.util.*;

public class SpiralMatrix {
    //--------------------  Solution  1 -------------------//
    // don't have to deal with 1 row specific
    public List<Integer> spiralOrder(int[][] matrix) {
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
            for(int i = c2; i >= c1 && r1 <= r2; i--) { // r1 <= r2 (not needed if input is square)
                res.add(matrix[r2][i]);
            }
            r2--;
            for(int i = r2; i >= r1 && c1 <= c2; i--) { // c1 <= c2 (not needed if input is square)
                res.add(matrix[i][c1]);
            }
            c1++;
        }
        return res;
    }

    //--------------------  Solution 2 -------------------//
    // directions, steps and start point
    public List<Integer> spiralOrder2(int[][] matrix) {
        // input validation
        List<Integer> res = new ArrayList();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }
        int[] steps = {matrix[0].length, matrix.length - 1};      // {numCols, numRows-1}
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // {right, down, left, up}
        int turns = 0;     // index of directions
        int r = 0, c = -1; // start point (c = -1) out of bound to make code more unified
        while (steps[turns % 2] != 0) { // either horizontal or vertical still has left steps to do
            for (int i = 0; i < steps[turns % 2]; i++) {
                // update r, c
                r += directions[turns][0];
                c += directions[turns][1];
                // append res
                res.add(matrix[r][c]);
            }
            steps[turns % 2]--;      // decr steps for either horizontal or vertical
            turns = (turns + 1) % 4; // make a turn
        }
        return res;
    }
}
