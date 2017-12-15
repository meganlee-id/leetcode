package com.meganlee;

import java.util.*;

public class ContainerWithMostWater {
    //----------------- Solution 1 ------------------//
    // brute-force, find all pairs: Time Limit Exceeded
    public int maxArea(int[] height) {
        // input validation
        if (height == null || height.length <= 1) {
            return 0;
        }

        // 2 pointers
        int max = 0, N = height.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    //----------------- Solution 2 ------------------//
    // 2-pointer window shrinking
    public int maxArea2(int[] height) {
        // input validation
        if (height == null || height.length <= 1) {
            return 0;
        }

        // 2 pointers, shrinking window
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ){
            int area = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(max, area);
            if (height[i] < height[j]) {
                i++;
            } else { // if height[i] == height[j] we could throw either side
                j--;
            }
        }
        return max;
    }
}
