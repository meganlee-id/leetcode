package com.meganlee;

import java.util.*;
import java.util.stream.*;

public class TrappingRainWater {
    //----------------- Solution 1 ------------------//
    // incremental, find pattern
    // find the 1st 
    public int trap(int[] A) {
        // input checking
        if (A == null || A.length < 3) {  // in order to trap water, at least 3 bars
            return 0;
        }

        int[] B = new int[A.length];      // parallel capacity array, how much water each cell holds
        int leftMax = A[0];
        for (int i = 1; i < A.length; i++) {
            // if bar heights start to climb, back up and updateyfrdrtvygrerfgh
            if (A[i - 1] < A[i]) {
                // update capacity array
                int waterLevel = Math.min(A[i], leftMax);
                for (int j = i - 1; A[j] < waterLevel; j--) {
                    B[j] =  waterLevel - A[j];
                }
                // update max/maxIndex
                leftMax = Math.max(leftMax, A[i]);
            }
        }
        return Arrays.stream(B).sum();
    }

    //----------------- Solution 2 ------------------//
    // incremental, using stack
    public int trap2(int[] A) {
        // input checking
        if (A == null || A.length < 3) {  // in order to trap water, at least 3 bars
            return 0;
        }

        // use stack to store the indices of a decreasing series of bar heights
        Stack<Integer> s = new Stack();
        int res = 0;
        int i = 0;
        while (i < A.length) {
            if (s.isEmpty() || A[s.peek()] >= A[i]) {
                s.push(i); 
                i++;
            } else {
                int bottom = A[s.pop()];
                int w = s.isEmpty() ? 0 : (i - s.peek() - 1); // width of extra water
                int h = s.isEmpty() ? 0 : Math.min(A[s.peek()], A[i]) - bottom; // height of extra water
                res += w * h; // (w * h) is extra water
            }
        }
        return res;
    }

    //----------------- Solution 3 ------------------//
    // fix one bar, expand on both sides: (parallel array)
    public int trap3(int[] A) {
        // input checking
        if (A == null || A.length < 3) {
            return 0;
        }

        // parallel arrays: record boundaries(maxBar) from both sides
        int N = A.length;
        int[] L = Arrays.copyOf(A, N);
        int[] R = Arrays.copyOf(A, N);
        for (int i = 1, j = N - 2; i < N; i++, j--) {
            L[i] = Math.max(L[i - 1], A[i]);
            R[j] = Math.max(R[j + 1], A[j]);
        }

        // calculate sum
        return IntStream.range(0, N).map(i -> Math.min(L[i], R[i]) - A[i]).sum();
    }


    //----------------- Solution 4 ------------------//
    // 2 pointers, shrinking window.
    // fix Math.max(leftMax, rightMax) side, move the other side
    public int trap4(int[] A) {
        // input validation
        if (A == null || A.length < 3) {
            return 0;
        }

        // 2 pointers, sliding window
        int sum = 0, leftMax = 0, rightMax = 0;
        for (int lo = 0, hi = A.length - 1; lo < hi; ) {
            // update leftMax and rightMax
            leftMax  = Math.max(leftMax,  A[lo]);
            rightMax = Math.max(rightMax, A[hi]);
            // fix left side, move right side
            if (leftMax > rightMax) {
                sum += rightMax - A[hi];
                hi--;
            // fix right side, shrink left side
            } else {
                sum += leftMax - A[lo];
                lo++;
            }
        }
        return sum;
    }
}