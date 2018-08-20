package com.meganlee;

import java.util.*;

public class UniquePath2 {
    /**
     * Input Checking:
     * 1) each row [1 -> len-1] must be non-null
     * 2) all rows have the same len
     * 3) each element is either 0 or 1
     */

    //---------------------- Solution 1 ------------------------//
    // pure recursion (time limit exceed)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // input checking
        if (obstacleGrid == null || obstacleGrid.length == 0 ||
            obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        return helper(obstacleGrid, m, n);
    }

    private int helper(int[][] grid, int m, int n) {
        if (m == 0 || n == 0 || grid[m - 1][n - 1] == 1) { // case 1: out of boundary or blocker (order is important!!!)
            return 0;

        } else if (m == 1 && n == 1) {                     // case 2: non-blocker start point
            return 1;

        } else {                                           // case 3: general recursive call
            return helper(grid, m - 1, n) + helper(grid, m, n - 1);
        }
    }


    //---------------------- Solution 2 ------------------------//
    // pure recursion with cache
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        // input checking
        if (obstacleGrid == null || obstacleGrid.length == 0 ||
            obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        // REMEMBER TO FILL CACHE WITH DEFAULT VALUE -1, IF THE DEFAULT 0 IS A POSSIBLE CELL VALUE
        int[][] cache = new int[m + 1][n + 1];
        for (int[] row: cache) {
            Arrays.fill(row, -1);
        }
        return numOfpaths(obstacleGrid, m, n, cache);
    }

    private int numOfpaths(int[][] grid, int m, int n, int[][] cache) {
        // step 1: update cache
        if (cache[m][n] == -1) {
            if (m == 0 || n == 0 || grid[m - 1][n - 1] == 1) {  // case 1 BASE CASE: out of boundary OR blocker cell
                cache[m][n] = 0;

            } else if (m == 1 && n == 1) {                      // case 2 BASE CASE: non-blocker start point cell
                cache[m][n] = 1;

            } else {                                            // case 4 GENERAL CASE
                cache[m][n] = numOfpaths(grid, m - 1, n, cache) +
                              numOfpaths(grid, m, n - 1, cache);
            }
        }
        // step 2: return cached value
        return cache[m][n];
    }

    //---------------------- Solution 3 ------------------------//
    // dp with 2D cache
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        // input checking
        if (obstacleGrid == null || obstacleGrid.length == 0 ||
            obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        // create a 2D table for storing intermediate results
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 0) { //----- non-blocker
                    if (i == 1 && j == 1) {  // intial cell
                        dp[i][j] = 1;
                    } else {                 // other cells
                        dp[i][j]= dp[i - 1][j] + dp[i][j - 1];
                    }
                } //----- blocker, leave 0 as the value
            }
        }
        return dp[m][n];
    }


    //---------------------- Solution 4 ------------------------//
    // space-saving dp
    public int uniquePathsWithObstacles4(int[][] obstacleGrid) {
        // input checking
        if (obstacleGrid == null || obstacleGrid.length == 0 ||
            obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        // use a 1D array to record intermediate result
        int width = obstacleGrid[0].length;
        int[] dp = new int[width]; // an extra row at index -1
        dp[0] = 1;                 // dp[-1][0] = 1, all dp[x][-1] is 0 (initialized state)
        for (int[] row : obstacleGrid) {
            for (int col = 0; col < width; col++) {
                if (row[col] == 1) // if it's a wall
                    dp[col] = 0;
                else if (col > 0)  // if not first col up + left (if it's first row. notice that left is 0)
                    dp[col] += dp[col - 1];
            }
        }
        return dp[width - 1];
    }
}
