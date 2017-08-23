package com.meganlee;

import java.util.*;

public class LongestValidParentheses {
    //-------------- Solution 1 --------------------//
    // dynamic programming (a hard dp problem)
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // definition: longest len ends in index 1
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') { // cur is ')'
                int start = i - dp[i - 1] - 1;  // start is the boundary index
                if (start >= 0 && s.charAt(start) == '(') {
                    dp[i] += dp[i - 1] + 2;      // embedded matching
                    dp[i] += (start - 1 >= 0) ? dp[start - 1] : 0; // sequential addition
                }
                res = Math.max(res, dp[i]);
            } // else is '(': there is no valid substring ending in '(', dp[i] => 0;
        }
        return res;
    }

    //------------------ Solution 2 ----------------------//
    // stack: store index
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;   // global max
        Stack<Integer> stack = new Stack();
        int start = -1; // boundary: (start + 1) is the first index for cur valid paren substring
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);   // put the index in stack
            } else {
                if (stack.empty()) {
                    start = i;   // set new boundary
                } else {
                    stack.pop(); // pops out the matching '('
                    int len = i - (stack.empty() ? start : stack.peek());
                    res = Math.max(res, len);
                }
            }
        }
        return res;
    }
}
