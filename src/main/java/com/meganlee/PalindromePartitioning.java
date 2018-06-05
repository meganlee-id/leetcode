package com.meganlee;

import java.util.*;

public class PalindromePartitioning {
    //--------------------- Solution --------------------------//
    // backtracing
    public List<List<String>> partition(String s) {
        // input validation
        List<List<String>> res = new ArrayList();
        if (s == null || s.length() == 0) {
            return res;
        }
        boolean[][] cache = buildCache(s); // could replace buildCache with isPalindrome, others are the same
        populateResult(s, 0, new ArrayList(), res, cache);
        return res;
    }

    private void populateResult(String s, int start, List<String> partition, List<List<String>> res, boolean[][] cache) {
        // base case
        if (start >= s.length()) {
            res.add(new ArrayList(partition));
        }

        // general case
        for (int end = start; end < s.length(); end++) {
            if (cache[start][end]) { // s[start, end] is palidrome
                partition.add(s.substring(start, end + 1)); // end is inclusive
                populateResult(s, end + 1, partition, res, cache);
                partition.remove(partition.size() - 1);     // backtrace: remove last elem
            }
        }
    }

    // :( buildCache is not faster than simply check isPalindrome!!
    private boolean[][] buildCache(String s) {
        int N = s.length();
        boolean[][] cache = new boolean[N][N];
        for (int len = 1; len <= N; len++) {
            for (int start = 0; start + len - 1 < N; start++) {
                int end = start + len - 1;
                cache[start][end] = (s.charAt(start) == s.charAt(end)) && (len <= 2 || cache[start + 1][end - 1]);
            }
        }
        return cache;
    }

    //************ UTIL NOT USED *************//
    // this is faster in practice
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start > end;
    }
}
