package com.meganlee;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    //-----------------  Solution 1  -----------------------//
    // Incremental - iterative (Time Limit Exceeded)
    public List<List<Integer>> combine(int n, int k) {
        // input checking
        if (n <= 0 || k <= 0 || k > n) {
            return new ArrayList<List<Integer>>();
        }

        // --- First Level: when k == 1
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<List<Integer>> resLast = new ArrayList<List<Integer>>(); // last level
        for (int i = 1; i <= n; i++) {
            List<Integer> item = new ArrayList<Integer>();
            item.add(i);
            resLast.add(item);
        }

        // --- Other levels: add number when k = 2 --> k
        for (int i = 2; i <= k; i++) {
            for (List<Integer> comb: resLast) {
                int startNum = comb.get(comb.size() - 1) + 1;
                for (int j = startNum; j <= n; j++) {
                    List<Integer> newCombo = new ArrayList<Integer>(comb);
                    newCombo.add(j);
                    res.add(new ArrayList<Integer>(newCombo));
                }
            }
            // after each level, update res/resLast
            resLast = res;
            res = new ArrayList<List<Integer>>();
        }
        return resLast;
    }

    //-----------------  Solution 2  ---------------------//
    // classic recursive combination solution
    public List<List<Integer>> combine2(int n, int k) {
        // input checking
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        helper(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> comb, int k, int n, int start) {
        // base case
        if (comb.size() == k) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }

        // general case
        for (int i = start; i <= n; i++) {
            comb.add(i);
            helper(res, comb, k, n, i + 1);
            comb.remove(comb.size() - 1);
        }
    }

    /////////////////////////   TEST   /////////////////////////////
    public static void main(String[] args) {
        Combinations solution = new Combinations();
        List<List<Integer>> result = solution.combine(4, 2);
        PrettyPrinter.print2DList(result);
    }
}