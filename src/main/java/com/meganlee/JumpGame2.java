package com.meganlee;

import java.util.*;

public class JumpGame2 {
    //------------------- Solution 1 ----------------------//
    // Similar to Graph BFS
    public int jump(int[] A) {
        // input validation
        if (A == null || A.length <= 1) {
            return 0;
        }

        // level by level
        int steps = 0;
        for (int i = 0, end = 0, nextEnd = 0; i <= end; i++) {
            nextEnd = Math.max(nextEnd, i + A[i]); // expand end boundary of next level
            if (nextEnd >= A.length - 1) {       // fast break: last index reachable, return true
                return steps + 1;
            }
            if (i == end) { // current level deplete, update index
                steps++;
                end = nextEnd;
            }
        }
        return 0; // if we reach here, could not reach last elem
    }


    //------------------- Solution 2 ----------------------//
    // DP, O(N^2) - time limits exceeded on LeetCode
    public int jump2(int[] A) {
        // input validation
        if (A == null || A.length <= 1) {
            return 0;
        }

        int N = A.length;
        int[] steps = new int[N];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && A[j] + j >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                    break; // have break is correct here (1st reachable place is minimus)
                }
            }
        }
        return steps[A.length - 1];
    }
}
