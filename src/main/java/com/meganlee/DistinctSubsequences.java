package com.meganlee;

import java.util.*;

public class DistinctSubsequences {
    //----------------   Solution 1  ----------------------//
    // Recursion (Time Limit Exceeded)
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        int S = s.length(), T = t.length();
        int res = 0;
        if (T == 0) {  //--- base case
            res = 1;
        } else if (S == 0) {
            res = 0;
        } else {       //--- general case
            res = numDistinct(s.substring(1), t); // =, NOT use s_1st_ch
            res += (s.charAt(0) == t.charAt(0)) ? numDistinct(s.substring(1), t.substring(1)) : 0; // +=, use s_1st_ch
        }
        return res;
    }

    //----------------   Solution 2  ----------------------//
    // Recursion with cache (Stack Overflow, for test4 "zzz....")
    public int numDistinct2(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        // create cache
        int S = s.length(), T = t.length();
        int[][] cache = new int[S + 1][T + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return helper(s, t, 0, 0, cache);
    }

    private int helper(String s, String t, int i, int j, int[][] cache) {
        int S = s.length(), T = t.length();
        // update cache
        if (cache[i][j] == -1) {
            if (j == T) {  //--- base case
                cache[i][j] = 1;
            } else if (i == S) {
                cache[i][j] = 0;
            } else {       //--- general case
                cache[i][j] = helper(s, t, i + 1, j, cache); // =, NOT use s_1st_ch
                cache[i][j] += (s.charAt(i) == t.charAt(j)) ? helper(s, t, i + 1, j + 1, cache) : 0;  // +=, use s_1st_ch
            }
        }
        // return cache
        return cache[i][j];
    }


    //----------------   Solution 3  ----------------------//
    // 2D-dp: s.substring(i) and t.substring(j)
    public int numDistinct3(String s, String t) {
        // input validation
        if (s == null || t == null) {
            return 0;
        }
        int S = s.length(), T = t.length();
        int[][] nums = new int[S + 1][T + 1]; // dp[sLen][tLen]
        // initialize the the dp table
        for (int i = 0; i <= S; i++) {
            nums[i][0] = 1;  // if lenT == 0, return 1
        }                    // if lenT != 0 && lenS == 0, nums[lenS][lenT] == 0 default value
        // dp
        for (int i = 1; i <= S; i++) {
            for (int j = 1; j <= T; j++) {
                nums[i][j] = nums[i - 1][j]; // =, NOT use s_cur_ch
                nums[i][j] += (s.charAt(i - 1) == t.charAt(j - 1)) ? nums[i - 1][j - 1] : 0;  // +=, use s_cur_ch
            }
        }
        return nums[S][T];
    }
}
