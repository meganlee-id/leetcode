package com.meganlee;

import java.util.*;

public class LongestValidParentheses {
    //------------------ Solution 1 ----------------------//
    // Time Limit Exceeded: Longest Valid Parenthesesbrute force; 2 pointers + valid checker
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }

    //------------------ Solution 2 ----------------------//
    // stack: store index 
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    //-------------- Solution 3 --------------------//
    // DP
    public int longestValidParentheses3(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        // definition: longest len ends in index 1
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') { // cur is ')'
                int start = i - dp[i - 1] - 1;  // start is the boundary index
                if (start >= 0 && s.charAt(start) == '(') {
                    dp[i] = dp[i - 1] + 2;      // embedded matching
                    dp[i] += (start - 1 >= 0) ? dp[start - 1] : 0; // sequential addition
                }
                res = Math.max(res, dp[i]);
            } // else is '(': there is no valid substring ending in '(', dp[i] => 0;
        }
        return res;
    }
}
