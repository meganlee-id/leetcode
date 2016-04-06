
public class RegularExpressionMatching {
    //------------------ Solution 1 ---------------------//
    // brute-force
    public boolean isMatch(String s, String p) {
        // case 1: p is empty
        if (p.length() == 0) {
            return "".equals(s);
        }

        // case 2: p's first char is: L (letter || .)
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (!sameFirstChar(s, p)) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }

        // case 2: wildcast in pattern: 'L*'
        } else {
            if (!sameFirstChar(s, p)) {
                return isMatch(s, p.substring(2));    // match zero
            } else {
                return isMatch(s, p.substring(2)) ||  // match zero
                        isMatch(s.substring(1), p);   // match more
            }
        }
    }

    private boolean sameFirstChar(String s, String p) {
        if (s.length() == 0) {
            return false;
        }
        return (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
    }

    //------------------ Solution 2 ---------------------//
    // dp
    public boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int pi = 1; pi <= p.length(); pi++) {
            for (int si = 0; si <= s.length(); si++) {
                // case 1: L*
                if (p.charAt(pi - 1) == '*') {
                    if (!sameChars(s, p, si, pi - 1)) {
                        dp[pi][si] = dp[pi - 2][si];
                    } else {
                        dp[pi][si] = dp[pi - 2][si] || dp[pi][si - 1];
                    }

                // case 2: L
                } else if (pi == p.length() || p.charAt(pi) != '*') {
                    if (!sameChars(s, p, si, pi)) {
                        dp[pi][si] = false;
                    } else {
                        dp[pi][si] = dp[pi - 1][si - 1];
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }

    private boolean sameChars(String s, String p, int si, int pi) {
        if (si == 0) {
            return false;
        }
        return (p.charAt(pi - 1) == '.' || s.charAt(si - 1) == p.charAt(pi - 1));
    }
}