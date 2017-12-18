package com.meganlee;

import java.util.*;

public class Triangle {
    //----------------- Solution 1 ---------------------//
    // recursion, divide and conquer
    // exponential time
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return Integer.MIN_VALUE;
        }
        return helper(triangle, 0, 0);
    }

    private int helper(List<List<Integer>> triangle, int row, int col) {
        // base case: if it's bottom layer, read number directly
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        // general case: another layer otehr than the last layers
        int left = helper(triangle, row + 1, col);
        int right = helper(triangle, row + 1, col + 1);
        return triangle.get(row).get(col) + Math.min(left, right); // cur_val + min(left, right)
    }


    //------------------- Solution 2 ----------------------//
    // bottom up: O(n^2)
    // similar to dp problem
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return Integer.MIN_VALUE;  // there might be negative values
        }
        // do not change the original triangle
        int N = triangle.size();
        int[] res = new int[N + 1]; // add a virtual layer, initialized to 0
        for (int row = N - 1; row >= 0; row--) {
            List<Integer> curRow = triangle.get(row);
            for (int col = 0; col < curRow.size(); col++) {
                res[col] = curRow.get(col) + Math.min(res[col], res[col + 1]);
            }
        }
        return res[0];
    }

    // instead of using int[], you might want to use List<Integer> as res
    public int minimumTotal3(List<List<Integer>> triangle) {
        // input check
        if (triangle == null || triangle.size() == 0) {
            return Integer.MIN_VALUE; // there might be negative values
        }
        // bottom up
        int N = triangle.size();
        List<Integer> res = new ArrayList(triangle.get(N - 1)); // clone bottom layer. Do NOT change original triangle
        for (int row = N - 2; row >= 0; row--) {
            List<Integer> curRow = triangle.get(row);
            for (int col = 0; col < curRow.size(); col++) {
                res.set(col, curRow.get(col) + Math.min(res.get(col), res.get(col + 1))); // use list.set(index, elem)
            }
        }
        return res.get(0);
    }
}
