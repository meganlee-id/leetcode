
public class WildcardMatching {
    //-------------- Solution 1 -------------------//
    // dp
    public boolean isMatch(String s, String p) {
        // there is a tricky unreasonable test case in Leetcode
        // uncomment the following line to pass
        // if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*') return false;

        int S = s.length(), P = p.length();
        boolean[][] dp = new boolean[P + 1][S + 1];
        dp[0][0] = true;
        for (int pi = 1; pi <= P; pi++) {
            for (int si  = 0; si <= S; si++) {
                // CASE 1: L
                if (p.charAt(pi - 1) != '*') {
                    if (!same(s, p, si, pi)) {
                        dp[pi][si] = false;
                    } else {
                        dp[pi][si] = dp[pi - 1][si - 1];
                    }

                // CASE 2: *
                } else {
                    dp[pi][si] = (si != 0) ? (dp[pi - 1][si] || dp[pi][si - 1])
                                           :  dp[pi - 1][si];
                }
            }
        }
        return dp[P][S];
    }

    private boolean same(String s, String p, int si, int pi) {
        if (si == 0) {
            return false;
        }
        return p.charAt(pi - 1) == '?' || p.charAt(pi - 1) == s.charAt(si - 1);
    }
}