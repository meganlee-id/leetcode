package com.meganlee;

import java.util.*;

public class LargestRectangleInHistogram {
    // ---------------  Solution 1 ---------------------//
    // brute-force find all pairs: with one optimization T=O(N^2)
    // Time Limit Exceeded:
    // -- could not pass LeetCode for time limits for acsending order {0, 1, 2, 3, 4, .., 1000}
    public int largestRectangleArea(int[] h) {
        // input checking
        if (h == null || h.length == 0) {
            return 0;
        }
        int maxArea = 0;
        // i points to right most bar, j points to left most bar
        for (int i = 0; i < h.length; i++) {
            // optimization: if prev-bar >= cur-bar, prune calculation
            if (i != 0 && h[i - 1] >= h[i]) {
                continue;
            }
            int min = h[i];
            for (int j = i; j < h.length; j++) { // j start from i, not from i+1
                min = Math.min(min, h[j]);  // update min
                maxArea = Math.max(maxArea, min * (j - i + 1)); // update areaa
            }
        }
        return maxArea;
    }

    // ---------------  Solution 2 ---------------------//
    // incremental--stack
    public int largestRectangleArea2(int[] h) {
        // input checking
        if (h == null || h.length == 0) {
            return 0;
        }

        Stack<Integer> s = new Stack();
        h = Arrays.copyOf(h, h.length + 1); // append 0 at the end
        int maxArea = 0, i = 0;
        while (i < h.length) { // no i++ here
            // stack: indices of a increasing heights, find 1st < me
            if (s.isEmpty() || h[s.peek()] < h[i]) {
                s.push(i);
                i++;    // i++ here
            // !s.isEmpty() && A[s.peek()] >= A[i]
            } else {    // no i++, we need to keep popping util 1st one < me
                // pop top element and use the popped element as the min bar
                int minBar = h[s.pop()];
                int width = s.isEmpty() ? i : (i - s.peek() - 1);
                maxArea = Math.max(maxArea, minBar * width);
            }
        }
        return maxArea;
    }


    //---------------  Solution 3A ---------------------//
    // fix one bar, expand on both sides (Naive):  Time Limit Exceeded
    public int largestRectangleArea3(int[] height) {
        // input checking
        if (height == null || height.length == 0) {
            return 0;
        }

        int maxArea = 0, N = height.length;
        for (int i = 0; i < N; i++) {
            int start = i, end = i, h = height[i]; // use current bar as the 'h'eight
            while (start >= 0 && height[start] >= h ) {
                start--;    // `start` stops at the bar which is < h, or stops at -1
            }
            while (end < N && height[end] >= h) {
                end++;      // `end`   stops at the bar which is < h, or stops at N
            }
            maxArea = Math.max(maxArea, (end - start - 1) * h);
        }
        return maxArea;
    }

    // NO solution 3B there is no dp (parallel array for this problem)
}

