package com.meganlee;

public class SpiralMatrix2 {
    //--------------------  Solution 1 -------------------//
    // directions, steps and start point
    public int[][] generateMatrix(int n) {
        // input checking
        if (n < 0) {
            return null;
        }

        int[][] matrix = new int[n][n]; // test case: input == 0; expect [];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // {right, down, left, up}
        int[] steps = {n, n - 1}; // {numCols, numRows-1}
        int go = 0;               // index of directions
        int r = 0, c = -1;        // start point
        int num = 1;              // start number
        while (steps[go % 2] != 0) {
            for (int i = 0; i < steps[go % 2]; i++) {
                r += directions[go][0];
                c += directions[go][1];
                matrix[r][c] = num++;
            }
            steps[go % 2]--;
            go = (go + 1) % 4;
        }
        return matrix;
    }

    //------------------ Solution ----------------------//
    // classic algorithm: use 4 bounds (for square, using 2 lo, hi)
    public int[][] generateMatrix2(int n) {        
        // input checking
        if (n < 0) {
            return null;
        }

        int[][] matrix = new int[n][n];
        int r1 = 0, r2 = n-1;
        int c1 = 0, c2 = n-1;
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
            
            for (int i = c2; i >= c1; i--) {
                if (r1 <= r2) {
                    matrix[r2][i] = num++;
                }
            }
            r2--;
            
            for (int i = r2; i >= r1; i--) {
                if (c1 <= c2) {
                    matrix[i][c1] = num++;
                }
            }
            c1 ++;
        }
        
        return matrix;
    }
}
