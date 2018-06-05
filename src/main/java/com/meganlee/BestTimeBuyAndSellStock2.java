package com.meganlee;

/***** unlimited transactions ******/

public class BestTimeBuyAndSellStock2 {
    //--------------------  Solution 1 ------------------------//
    // brute force (Time Limit Exceeded)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        return helper(prices, 0);
    }

    public int helper(int prices[], int s) {
        // base
        int res = 0, N = prices.length; // prices won't be null
        if (s >= N) {
            return 0;
        }
        // general
        for (int start = s; start < N; start++) {       // 2 pointer: start
            for (int end = start + 1; end < N; end++) { // 2 pointer: end
                int diff = prices[end] - prices[start]; // the 1st transaction
                if (diff > 0) {
                    res = Math.max(res, diff + helper(prices, end + 1));
                }
            }
        }
        return res;
    }

    //--------------------  Solution 2 ------------------------//
    // diff[]
    public int maxProfit2(int[] prices) {
        // input checking
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // diff[] --> sum up all non-negative number in it
        int res = 0;
        for (int i = 1; i < prices.length; i++) {  // i starts from 1
            int diff = prices[i] - prices[i - 1];
            res += Math.max(0, diff);
        }
        return res;
    }

    //--------------------  Solution 3 ------------------------//
    // dp[]
    public int maxProfit3(int[] prices) {
        // input checking
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        // dp
        int N = prices.length;
        int[] dp = new int[N];
        int maxBase = 0 - prices[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], maxBase + prices[i]);
            maxBase = Math.max(maxBase, dp[i] - prices[i]);
        }
        return dp[N - 1];
    }

    //--------------------  Solution 4 ------------------------//
    // dp: space saving
    public int maxProfit4(int[] prices) {
        // input checking
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        // dp: space saving
        int res = 0;
        int maxBase = res - prices[0]; // maxBase: $ i have after last buy
                                       // res: bst profit before buy; -p[buy] is the cost; +p[sell] is profit 
        for (int p: prices) {
            res = Math.max(res, maxBase + p);
            maxBase = Math.max(maxBase, res - p);
        }
        return res;
    }
}
