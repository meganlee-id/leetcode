package com.meganlee;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class TrappingRainWater {
    //----------------- Solution 1 ------------------//
    // incremental, find pattern
    public int trap(int[] A) {
        // input checking
        if (A == null || A.length < 3) {  // in order to trap water, at least 3 bars
            return 0;
        }

        int[] B = new int[A.length];      // parallel capacity array, how much water each cell holds
        int leftMax = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                // update capacity array
                int bar = Math.min(A[i], leftMax);
                for (int j = i - 1; A[j] < bar; j--) {
                    B[j] =  bar - A[j];
                }
                // update max/maxIndex
                leftMax = Math.max(leftMax, A[i]);
            }
        }

        return Arrays.stream(B).sum();
    }

    //----------------- Solution 2 ------------------//
    // incremental, using stack
    public int trap2(int[] height) {
        // input validation
        if (height == null || height.length <= 1) {
            return 0;
        }

        // use stack to store the indices of a decreasing series of bar heights
        Stack<Integer> s = new Stack<>();
        int water = 0, N = height.length;
        for (int i = 0; i < N; ) {
            if (s.isEmpty() || height[s.peek()] >= height[i]) {
                s.push(i);
                i++;
            } else {
                int bottom = height[s.pop()];
                int extraWater = s.isEmpty() ? 0 : (Math.min(height[s.peek()], height[i]) - bottom) * (i - s.peek() - 1);
                water += extraWater;
            }
        }
        return water;
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
    // 2 pointers, shrinking window
    public int trap4(int[] height) {
        // input validation
        if (height == null || height.length < 3) {
            return 0;
        }

        // 2 pointers, sliding window
        int sum = 0;
        for (int i = 0, j = height.length - 1, k = 0; i < j; ) { // initialize k out side embedded loop (i = k)
            if (height[i] < height[j]) {
                for (k = i + 1; height[k] < height[i]; k++) {    // k won't skip array boundary, since height[j] > height[j]
                    sum += height[i] - height[k];
                }
                i = k;
            } else {
                for (k = j - 1; height[j] > height[k]; k--) {    // k won't skip array boundary, since height[i] <= height[j]
                    sum += height[j] - height[k];
                }
                j = k;
            }
        }
        return sum;
    }


    ///////////////////  TEST //////////////////////
    private static void test(TrappingRainWater solution, int[] bars) {
        PrettyPrinter.print1DArray(bars);
        System.out.println(solution.trap3(bars));
    }


    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] bars = {9,6,8,8,5,6,3};
        test(solution, bars);
    }
}