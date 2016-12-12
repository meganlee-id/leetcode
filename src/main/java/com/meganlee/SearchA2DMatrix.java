package com.meganlee;

import java.util.function.Function;

public class SearchA2DMatrix {
    //------------------ Solution 1 ---------------------//
    // treat the whole 2D matrix as a 1D array T = O(lg(N^2)) = O(lgN)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int M = matrix.length, N = matrix[0].length;
        int lo = 0, hi = M * N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int row = mid / N, col = mid % N;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

    //------------------ Solution 2 ---------------------//
    // twice binary : O(lgN) + O(lgM)
    // this is a demo of lambda in Java 8
    public boolean searchMatrix2(int[][] matrix, int target) {
        // input validation
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        // first find the row
        int numRows = matrix.length, numCols = matrix[0].length;
        int row = findTarget(r -> matrix[r][0], target, numRows);
        if (row == -1) {
            return false;
        }
        int col = findTarget(c -> matrix[row][c], target, numCols);
        if (col == -1) {
            return false;
        }
        return matrix[row][col] == target;
    }

    private int findTarget(Function<Integer, Integer> arr, int target, int length) {
        int lo = 0, hi = length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.apply(mid) == target) {
                return mid;
            } else if (arr.apply(mid) > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi; // return hi, the first elem < target
    }
}
