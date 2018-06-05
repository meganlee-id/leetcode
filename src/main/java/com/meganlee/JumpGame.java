package com.meganlee;

public class JumpGame {
    //------------------- Solution 1 -------------------//
    // Range Expanding
    public boolean canJump(int[] A) {
        // input validation
        if (A == null || A.length <= 1) {
            return true;
        }

        for (int i = 0, end = 0; i <= end; i++) { // i <= end!
            end = Math.max(end, i + A[i]);   // expand end boundary in each step
            if (end >= A.length - 1) {       // fast break: last index reachable, return true
                return true;
            }
        }
        return false;   // end of loop, last index non-reachable
    }


    //------------------- Solution 2 -------------------//
    // DP, O(N^2) - time limits exceeded on LeetCode
    public boolean canJump2(int[] A) {
        // input validation
        if (A == null || A.length <= 1) {
            return true;
        }

        int N = A.length;
        boolean[] dp = new boolean[N];  // dp[n] --> whether A[k] is reachable from A[0]
        dp[0] = true;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && A[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N - 1];

    }
}
