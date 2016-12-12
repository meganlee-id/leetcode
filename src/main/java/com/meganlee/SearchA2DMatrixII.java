 package com.meganlee;

 public class SearchA2DMatrixII {
    //------------------ Solution 1 ---------------------//
    // single-step throw row or col -> O(M + N)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
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

    private boolean helper(int[][] matrix, int x1, int x2, int y1, int y2, int target) {
        // base case
        if (x1 > x2 || y1 > y2) {
            return false;
        }
        // step 1: find the pivot in the mid row
        int midRow = x1 + (x2 - x1) / 2;    // get the mid row
        int midCol = findMidCol(matrix, midRow, y1, y2, target); // find first elem < target
        if (midCol != -1 && matrix[midRow][midCol] == target) {
            return true;
        }
        // step 2: recursivelly call on 2 smaller matrix
        return helper(matrix, x1, midRow - 1, midCol + 1, y2, target) ||
               helper(matrix, midRow + 1, x2, y1, midCol, target);
    }

    private int findMidCol(int[][] matrix, int row, int y1, int y2, int target) {
        while (y1 <= y2) {
            int mid = y1 + (y2 - y1) / 2;
            if (matrix[row][mid] == target) {
                return mid;
            } else if (matrix[row][mid] < target) {
                y1 = mid + 1;
            } else {
                y2 = mid - 1;
            }
        }
        return y2;
    }
}