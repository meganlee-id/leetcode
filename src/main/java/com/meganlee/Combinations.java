package com.meganlee;

import java.util.*;

public class Combinations {
    //-----------------  Solution 2  ---------------------//
    // classic recursive combination solution
    public List<List<Integer>> combine(int n, int k) {
        // input checking
        if (n <= 0 || k <= 0 || k > n) {
            return new ArrayList();
        }
        List<List<Integer>> res = new ArrayList();
        helper(res, new ArrayList(), k, n, 1);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> comb, int k, int n, int start) {
        // base case
        if (comb.size() == k) {
            res.add(new ArrayList(comb));
            return;
        }
        // general case
        for (int num = start; num <= n; num++) {
            comb.add(num);
            helper(res, comb, k, n, num + 1);
            comb.remove(comb.size() - 1);
        }
    }

    //-----------------  Solution 2  -----------------------//
    // Incremental - iterative (Time Limit Exceeded)
    public List<List<Integer>> combine2(int n, int k) {
        // input checking
        if (n <= 0 || k <= 0 || k > n) {
            return new ArrayList();
        }
        // --- First Level: when k == 0
        List<List<Integer>> res = new ArrayList(Arrays.asList(new ArrayList()));
        // --- Other levels: add number when k = 1 --> k
        for (int i = 1; i <= k; i++) {
            List<List<Integer>> newRes = new ArrayList();
            for (List<Integer> comb: res) {
                int start = comb.isEmpty() ? 1 : comb.get(comb.size() - 1) + 1; // check if comb.isEmpty()
                for (int num = start; num <= n; num++) {
                    comb.add(num);
                    newRes.add(new ArrayList(comb));
                    comb.remove(comb.size() - 1);
                }
            }
            // after each level, update res/res
            res = newRes;
        }
        return res;
    }

}