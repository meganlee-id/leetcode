package com.meganlee;

/****** k transactions ******/

public class BestTimeBuyAndSellStock4 {
    //-------------- Solution -------------------//
    // dp[k][i]: rotate 2 rows
    public int maxProfit(int num, int[] prices) {
        // input checking
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        // fast return
        int N = prices.length;
        if (num > N / 2) { // same as res of unlimited tranX
            return fastLane(prices);
        }
        // dp[k][i]
        int[][] dp = new int[2][N]; // rotate between 2 rows, use k%2 
        for (int k = 1; k <= num; k++) {
            int maxBase = 0 - prices[0];
            for (int i = 1; i < N; i++) {
                dp[k % 2][i] = Math.max(dp[k % 2][i - 1], maxBase + prices[i]);
                maxBase  = Math.max(maxBase, dp[(k - 1) % 2][i] - prices[i]);
            }
        }
        return dp[num % 2][N - 1];
    }
    
    // optimization, same as BestTimeBuyAndSellStock2.java solution 2
    private int fastLane(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1]; // sum up all positive diffs
            res += Math.max(0, diff);
        }
        return res;
    }

    //---- if we want more space saving, we could process col-by-col -------//
    // 2 columns:   dp[k][2]
    // maxBase col: maxBase[k]
}

