package com.meganlee;

public class SpiralMatrix2 {
    //------------------ Solution 1----------------------//
    // classic algorithm: use 4 bounds (for square, using 2 lo, hi)
    public int[][] generateMatrix(int n) {        
        // input checking
        if (n < 0) {
            return null;
        }
        int[][] matrix = new int[n][n];
        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;
        int num = 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                matrix[r1][i] = num++;
            }
            r1++;
            for (int i = r1; i <= r2; i++) {
                matrix[i][c2] = num++;
            }
            c2--;
            for (int i = c2; i >= c1; i--) {  // no checking on r1,r2 compared to SpiralMatrix.java
                matrix[r2][i] = num++;
            }
            r2--;
            for (int i = r2; i >= r1; i--) {  // no checking on c1,c2 compared to SpiralMatrix.java
                matrix[i][c1] = num++;
            }
            c1++;
        }
        return matrix;
    }

    //--------------------  Solution 2 -------------------//
    // directions, steps and start point
    public int[][] generateMatrix2(int n) {
        // input checking
        if (n < 0) {
            return null;
        }
        int[][] matrix = new int[n][n]; // test case: input == 0; expect [];
        int[] steps = {n, n - 1}; // {numCols, numRows-1}
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // {right, down, left, up}
        int turns = 0;     // index of directions
        int r = 0, c = -1; // start point (c = -1) out of bound to make code more unified
        int num = 1;       // start number
        while (steps[turns % 2] != 0) {
            for (int i = 0; i < steps[turns % 2]; i++) { // either horizontal or vertical still has left steps to do
                r += directions[turns][0];
                c += directions[turns][1];
                // fill position
                matrix[r][c] = num++;
            }
            steps[turns % 2]--;      // decr steps for either horizontal or vertical
            turns = (turns + 1) % 4; // make a turn
        }
        return matrix;
    }
}
