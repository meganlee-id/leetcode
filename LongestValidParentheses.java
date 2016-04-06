import java.util.Stack;

public class LongestValidParentheses {
    //-------------- Solution 1 --------------------//
    // dynamic programming (a hard dp problem)
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int left = i - dp[i - 1] - 1;
                if (left >= 0 && s.charAt(left) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (left >= 1) {
                        dp[i] += dp[left - 1];
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    //------------------ Solution 2 ----------------------//
    // use stack to solve
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.empty()) {
                    start = i + 1;
                } else {
                    int left = stack.pop();
                    int len = stack.empty() ? (i - start + 1) : (i - stack.peek());
                    res = Math.max(res, len);
                }
            }
        }
        return res;
    }

}

// 1) valide parens: prefix -- n: '(', m: ')' n >= m
// 2) if [start, end - 1] is valid, [start, end] non-valid, move start to end + 1, use 1) to approve
// 3) special case () (()