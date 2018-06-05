package com.meganlee;

public class WildcardMatching {
    //-------------- Solution 1 -------------------//
    // brute-force (recursion) (Time Limit Exceeded)
    public boolean isMatch(String s, String p) {
        // input checks
        if (s == null || p == null) {
            return false;
        }
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // OPTIMIZE: but still timeout!!!
        p = p.replaceAll("\\*+", "*");  
 
        // CASE 1) pattern starts L: (letter || '?'')
        if (p.charAt(0) != '*') {
           return sameFirstChar(s, p) && isMatch(s.substring(1), p.substring(1));
        // CASE 2) pattern starts '*' (>=0 chars)
        } else {
            return isMatch(s, p.substring(1)) ||               // match 0 chars in s
                (!s.isEmpty() && isMatch(s.substring(1), p));  // match >=1 chars in s
        }
    }

    private boolean sameFirstChar(String s, String p) {
        return !s.isEmpty() && (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0));
    }

    //-------------- Solution 2 -------------------//
    // dp (direction: HEAD_TO_TOE)
    public boolean isMatch2(String s, String p) {
        // input checks
        if (s == null || p == null) {
            return false;
        }
        if (p.isEmpty()) {
            return s.isEmpty();
        }
 
        // dp
        int P = p.length(), S = s.length();
        boolean[][] dp = new boolean[P + 1][S + 1];
        dp[0][0] = true;  // initialization

        for (int pi = 1; pi <= P; pi++) {       // row-by-row
            for (int si = 0; si <= S; si++) {   // col-by-col
                // CASE 1) L   (letter || '?')
                if (p.charAt(pi - 1) != '*') {
                    dp[pi][si] = same(s, p, si, pi) && dp[pi - 1][si - 1];

                // CASE 2) '*' (>=0 chars)
                } else {
                    dp[pi][si] = dp[pi - 1][si] ||    // match 0 chars in s
                                 (si != 0 && dp[pi][si - 1]);   // match >=1 chars in s
                }
            }
        }
        return dp[P][S];
    }

    private boolean same(String s, String p, int si, int pi) {
        return si != 0 && (p.charAt(pi - 1) == '?' || p.charAt(pi - 1) == s.charAt(si - 1));
    }
}