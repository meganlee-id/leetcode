package com.meganlee;

import java.util.*;

public class MinimumPathSum {
    //------------------   Solution 1   ----------------------//
    // pure recursion (TIMEOUT)
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return helper(grid, m, n);
    }

    private int helper(int[][] grid, int m, int n) {
        if (m == 0 || n == 0) {         // -- base case: 1st row || 1st col
            return Integer.MAX_VALUE;
        } else if (m == 1 && n == 1) {  // -- base case: 1st cell
            return grid[0][0];
        } else {                        // -- general case:
            int above = helper(grid, m - 1, n);
            int left  = helper(grid, m, n - 1);
            return grid[m - 1][n - 1] + Math.min(above, left);
        }
    }

    //------------------   Solution 2   ----------------------//
    // recursion with cache
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // REMEMBER TO FILL CACHE WITH DEFAULT VALUE -1, IF THE DEFAULT 0 IS A POSSIBLE CELL VALUE
        int[][] cache = new int[m + 1][n + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return helper(grid, m, n, cache);
    }

    private int helper(int[][] grid, int m, int n, int[][] cache) {
        // update cache
        if (cache[m][n] == -1) {
            if (m == 0 || n == 0) {             // -- base case: 1st row || 1st col
                cache[m][n] = Integer.MAX_VALUE;
            } else if (m == 1 && n == 1) {      // -- base case: 1st cell
                cache[m][n] = grid[0][0];
            } else {                            // -- general case:
                int above = helper(grid, m - 1, n, cache);
                int left  = helper(grid, m, n - 1, cache);
                cache[m][n] = grid[m - 1][n - 1] + Math.min(above, left);
            }
        }
        // return value
        return cache[m][n];
    }


    //------------------   Solution 3   ----------------------//
    // dp with 2D cache
    public int minPathSum3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE); // -- base case: 1st row
        }

        for (int i = 1; i <= m; i++) {
            dp[i][0] = Integer.MAX_VALUE;        // -- base case: 1st col
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {          // -- base case: 1st cell
                    dp[i][j] = grid[0][0];
                } else {                         // -- general case
                    dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
    
	//-----------------    Solution 4  --------------------------//
    // space-saving dp
    public int minPathSum4(int[][] grid) {
        // use a 1D array to record intermediate result
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);  // -- base case: 1st row

        for (int i = 1; i <= m; i++) {
            dp[0] = Integer.MAX_VALUE;        // -- base case: 1st col
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {       // -- base case: 1st cell
                    dp[j] = grid[0][0];
                } else {                      // -- general case
                    dp[j] = grid[i - 1][j - 1] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[n];
    }
}