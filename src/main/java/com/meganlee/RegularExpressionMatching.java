package com.meganlee;


public class RegularExpressionMatching {
    //------------------ Solution 1 ---------------------//
    // brute-force (recursion) (direction: TOE_TO_HEAD)
    // NOTE: the way we resursively call isMatch make sure that
    //     1) p ALWAYS starts with a letter or dot(.)
    //     2) p NEVER starts with a *
    public boolean isMatch(String s, String p) {
        // input checks
        if (s == null || p == null) {
            return false;
        }
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // CASE 1) pattern starts with L
        if (p.length() == 1 || p.charAt(1) != '*') {
            return sameFirstChar(s, p) && isMatch(s.substring(1), p.substring(1));

        // CASE 2) pattern starts with L*
        } else {
            return isMatch(s, p.substring(2)) ||    // match 0 chars in s
                   sameFirstChar(s, p) && isMatch(s.substring(1), p);    // match >=1 chars in s
        }
    }

    private boolean sameFirstChar(String s, String p) {
        return !s.isEmpty() && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
    }


    //------------------ Solution 2 ---------------------//
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
        dp[0][0] = true; // initialization

        // NOTE 1: pi corresponse to p.charAt(pi - 1)
        //         si corresponse to s.charAt(si - 1)
        //
        // NOTE 2: pi could point to 3 types of chars:
        //          a) (letter || .) AND (next char NOT *)  <-- pick this as L
        //          b) (letter || .) AND (next char  IS *)  <-- skip
        //          c) * itself                             <-- pick this as L* (think about last line)

        for (int pi = 1; pi <= P; pi++) {       // row-by-row
            for (int si = 0; si <= S; si++) {   // col-by-col
                // CASE 1): L
                //--- current char is L ----||----- next char is not '*' -------||
                if (p.charAt(pi - 1) != '*' && (pi == P || p.charAt(pi) != '*')) {
                   dp[pi][si] = sameChar(s, p, si, pi) && dp[pi - 1][si - 1];

                // CASE 2): L*
                } else if (p.charAt(pi - 1) == '*') {
                    dp[pi][si] = dp[pi - 2][si] ||  // match 0 chars in s
                                 sameChar(s, p, si, pi - 1) && dp[pi][si - 1];  // match >=1 chars in s
                                // compare s_cur_char and p_pre_char
                }
            }
        }
        return dp[P][S];
    }

    private boolean sameChar(String s, String p, int si, int pi) {
        return si != 0 && (p.charAt(pi - 1) == '.' || s.charAt(si - 1) == p.charAt(pi - 1));
    }
}