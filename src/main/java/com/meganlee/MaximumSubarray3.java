package com.meganlee;

import java.util.*;

public class MaximumSubarray3 {
    //-------------- Solution -------------------//
    // dp[k][i]: http://www.lintcode.com/en/problem/maximum-subarray-iii/
    public int maxSubArray(int[] nums, int k) {
        // input validation
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return 0;
        }
        // dp
        int N = nums.length;
        int[][] dp = new int[k + 1][N + 1];    // first row is 0
        // transition
        for (int n = 1; n <= k; n++) {
            dp[n][n - 1] = Integer.MIN_VALUE;  // a trick to fill pre col
            int maxPre = dp[n - 1][n - 1];
            for (int i = n; i <= N; i++) {
                dp[n][i] = Math.max(dp[n][i - 1], maxPre) + nums[i - 1]; // i - 1 for accessing nums
                maxPre   = Math.max(maxPre, dp[n - 1][i]);
            }
        }
        // iterate last row
        int res = Integer.MIN_VALUE;
        for (int i = k; i <= N; i++) { // do not start with i = 0 (res might be negative)
            res = Math.max(res, dp[k][i]);
        }

        //---- Print DP states ------//
        // System.out.println("============== DP states ==============");
        // PrettyPrinter.print2DIntArray(dp);

        return res;
    }
}

