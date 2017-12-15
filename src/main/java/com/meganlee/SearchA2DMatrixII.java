 package com.meganlee;

 public class SearchA2DMatrixII {
    //------------------ Solution 1 ---------------------//
    // single-step throw row or col -> O(M + N)
    public boolean searchMatrix(int[][] matrix, int target) {
        // input validation
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        // find the target
        int r = 0, c = matrix[0].length - 1;
        while (r <= matrix.length - 1 && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

    //------------------ Solution 2 ---------------------//
    // divide and conquer: binary search
    public boolean searchMatrix2(int[][] matrix, int target) {
        // input validation
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        return helper(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
    }

    private boolean helper(int[][] matrix, int r1, int r2, int c1, int c2, int target) {
        // base case
        if (r1 > r2 || c1 > c2) {
            return false;
        }
        // step 1: find the pivot in the mid row
        int midR = r1 + (r2 - r1) / 2;    // get the mid row
        int midC = findMidCol(matrix, midR, c1, c2, target); // find first elem < target
        if (midC != -1 && matrix[midR][midC] == target) {
            return true;
        }
        // step 2: recursivelly call on 2 smaller matrix
        return helper(matrix, r1, midR - 1, midC + 1, c2, target) ||
               helper(matrix, midR + 1, r2, c1, midC, target);
    }

    private int findMidCol(int[][] matrix, int r, int c1, int c2, int target) {
        while (c1 <= c2) {
            int midC = c1 + (c2 - c1) / 2;
            if (matrix[r][midC] == target) {
                return midC;
            } else if (matrix[r][midC] < target) {
                c1 = midC + 1;
            } else {
                c2 = midC - 1;
            }
        }
        return c2;
    }
}