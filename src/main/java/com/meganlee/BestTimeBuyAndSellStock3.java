package com.meganlee;

import java.util.*;

/****** 2 transactions ******/

public class BestTimeBuyAndSellStock3 {
    //----------------- Solution 1 -------------------//
    // brute force, 4 pointers (Exceed Time Limit)
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int global = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                for (int m = j; m < N; m++) {
                    for (int n = m; n < N; n++) {
                        int gain = (prices[j] - prices[i]) + (prices[n] - prices[m]);
                        global = Math.max(gain, global);
                    }
                }
            }
        }
        return global;
    }

    //----------------- Solution 2 -------------------//
    // DC(divide and conquer) + DP
    // DC: FIND the solution
    // DP: OPTIMIZE the solution
    public int maxProfit2(int[] prices) {
        // input checking
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int N = prices.length;
        int[] maxFromStart = new int[N];
        int[] maxToEnd = new int[N];
        
        // DP: start --> end
        int min = prices[0];
        for (int i = 1; i < N; i++) {
            min = Math.min(min, prices[i]);
            maxFromStart[i] = Math.max(maxFromStart[i - 1], prices[i] - min);
        }
        
        // DP: end --> start
        int max = prices[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxToEnd[i] = Math.max(maxToEnd[i + 1], max - prices[i]);
        }
        
        // find the solution of 2 trades
        int maxProfit = 0;
        for (int i = 0; i < N; i++) {
            maxProfit = Math.max(maxProfit, maxFromStart[i] + maxToEnd[i]);
        }
        return maxProfit;
    }

    //-------------- Solution 3 -------------------//
    // dp[k][i]
    public int maxProfit3(int[] prices) {
        // input checking
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        // dp[k][i]
        int N = prices.length;
        int[][] dp = new int[3][N];
        for (int k = 1; k < 3; k++) {
            int maxBase = 0 - prices[0];
            for (int i = 1; i < N; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], maxBase + prices[i]);
                maxBase  = Math.max(maxBase, dp[k - 1][i] - prices[i]);
            }
        }
        return dp[2][N - 1];
    }

    //---- if we want more space saving, we could process col-by-col -------//
    // 2 columns:   dp[k][2]
    // maxBase col: maxBase[k]
}

