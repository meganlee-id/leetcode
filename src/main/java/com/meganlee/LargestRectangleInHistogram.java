package com.meganlee;

import java.util.*;

public class LargestRectangleInHistogram {
    // ---------------  Solution 1 ---------------------//
    // brute-force find all pairs: with one optimization T=O(N^2)
    // Time Limit Exceeded: could not pass LeetCode for time limits for acsending order {0, 1, 2, 3, 4, .., 1000}
    public int largestRectangleArea(int[] height) {
        // input checking
        if (height == null || height.length == 0) {
            return 0;
        }
        // i points to right most bar, j points to left most bar
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            // optimization, if prev-bar >= cur-bar, prune calculation
            if (i != 0 && height[i - 1] >= height[i]) {
                continue;
            }
            int min = height[i];
            for (int j = i; j < height.length; j++) { // j start from i, not from i+1
                min = Math.min(min, height[j]);
                maxArea = Math.max(maxArea, min * (j - i + 1));
            }
        }
        return maxArea;
    }

    // ---------------  Solution 2 ---------------------//
    // incremental--stack
    public int largestRectangleArea2(int[] height) {
        // input checking
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack();                   // for getting the left and right boundaries
        int maxArea = 0;
        int[] h = Arrays.copyOf(height, height.length + 1);   // add a padding 0 at the end for simplify the code
        for(int i = 0; i < h.length; ) { // no i++ here
            if (stack.isEmpty() || h[i] >= h[stack.peek()]) { // >, >= both ok
                stack.push(i);
                i++;    // i++ here
            } else {    // no i++
                // pop top element and use the popped element as the min bar
                int minBar = h[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
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
}

