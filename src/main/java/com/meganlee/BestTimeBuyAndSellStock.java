package com.meganlee;

import java.util.*;

/****** 1 transaction ******/

public class BestTimeBuyAndSellStock {
    //--------------  Solution 1 -------------------//
    // brute force (Time Limit Exceeded)
    public int maxProfit(int[] prices) {
        // input validation
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        // two pointers
        int N = prices.length;
        int res = 0;  // 0: buy n sell on the same day
        for (int start = 0; start < N; start++) {
            for (int end = start; end < N; end++) {
                res = Math.max(res, prices[end] - prices[start]);
            }
        }
        return res;
    }

    //--------------  Solution 2  -------------------//
    // one-pass scan. keep min updated
    public int maxProfit2(int[] prices) {
        // input validation
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        // record the min up util now
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int p : prices) {
            min = Math.min(min, p);
            res = Math.max(res, p - min);
        }
        return res;
    }

    //--------------  Solution 3  -----------------//
    // diff[]: MaximumSubArray.java solution3
    public int maxProfit3(int[] prices) {
        // input validation
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // calculate the result
        int sum = 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];  // get the diff
            sum = Math.max(sum, 0) + diff;  // local
            res = Math.max(res, sum);       // global
        }
        return res;
    }
}