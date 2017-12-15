package com.meganlee;

import java.util.*;

public class UniquePath {

    //------------ Solution 1: Pure Recursion ---------------//
    // Pure Recursion (exceed time limit)
    public int uniquePaths(int m, int n) {
        // input checking
        if (m <= 0 || n <= 0) {
            return 0;
        }

        if (m == 1 || n == 1) { // base cases
            return 1;
        } else {                // general cases
            return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        }
    }

    //--------- Solution 2: Top-down Recursion Cache ----------//
    // Recursion with cache
    public int uniquePaths2(int m, int n) {
        // input checking
        if (m <= 0 || n <= 0) {
            return 0;
        }

        // create a table for cache repeated used value
        int[][] cache = new int[m + 1][n + 1]; // cell's default value is 0
        return helper(m, n, cache);
     }
    
    public int helper(int m, int n, int[][] cache) {
        // step 1: update cache
        if (cache[m][n] == 0) {
            if (m == 1 || n == 1) { // -- base cases
                cache[m][n] = 1;
            } else {                // -- general cases
                cache[m][n] = helper(m - 1, n, cache) + helper(m, n - 1, cache);
            }
        }

        // step 2: return cached value
        return cache[m][n];
    }
    

    //------------ Solution 3: Bottom-up DP solution ---------------//
    // m X n space
    public int uniquePaths3(int m, int n) {
        // input validation
        if (m <= 0 || n <= 0) {
            return 0;
        }

        // create a 2D table for storing intermediate results
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) { // -- base cases
                    dp[i][j] = 1;
                } else {                // -- general cases
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
    
    
    //------------ Solution 4: Bottom-up DP solution ---------------//
    // memory saving
    public int uniquePaths4(int m, int n) {
        // input validation
        if (m <= 0 || n <= 0) {
            return 0;
        }

        // initial row
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[m];
    }

    
    //------------ Solution 5: Combination Formula -----------------//
    public int uniquePaths5(int m, int n) {
        // input validation
        if (m <= 0 || n <= 0) {
            return 0;
        }

        // base case
        if (m == 1 || n == 1) {
            return 1;
        }

        // calculate C(m+n-2, n-1)
        int denominator = 1, numerator = 1;
        for (int i = n - 1; i >= 1; i--) {
            numerator *= (m - 1) + i;   // starting from (m - 1) + (n - 1)   -->   (m - 1) + 1
            denominator *= i;           // starting form           (n - 1)   -->             1
            int factor = gcd(numerator, denominator);
            denominator /= factor;
            numerator /= factor;
        }
        return numerator / denominator;
    }

    // call gcd(Math.max(a, b), Math.min(a, b))
    // a >= b && a > 0 && b > 0
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    
    /////////////////////////////     TEST     //////////////////////////////////
    private static void test(UniquePath solution, int m, int n, int expected) {
        int actual = solution.uniquePaths(m, n);
        System.out.println(String.format("%-6d %-6d %-10d %-10d", m, n, expected, actual));
        System.out.println(actual == expected ? "PASS\n" : "ERROR!!\n");
    }
    public static void main(String[] args) {
        System.out.println(String.format("%-6s %-6s %-10s %-10s", "m", "n", "expected", "actual"));
        System.out.println("--------------------------------------");
        UniquePath solution = new UniquePath();
        test(solution, 0, 0, 0);
        test(solution, 1, 0, 0);
        test(solution, 12, 8, 31824);
        test(solution, 23, 12, 193536720);
    }
}



