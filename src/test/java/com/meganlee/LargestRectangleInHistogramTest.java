package com.meganlee;

import org.junit.*;

public class LargestRectangleInHistogramTest {
    LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
    private int calculate(int[] height) {
       return solution.largestRectangleArea2(height);
    }

    @Test
    public void testEmpty() {
       Assert.assertEquals(0, calculate(new int[]{}));
    }
    @Test
    public void testOne() {
       Assert.assertEquals(3, calculate(new int[]{3}));
    }
    @Test
    public void testWithZero() {
       Assert.assertEquals(9, calculate(new int[]{0, 0, 9}));
    }
    @Test
    public void testAllTheSame() {
       Assert.assertEquals(8, calculate(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
    @Test
    public void testAscending() {
       Assert.assertEquals(20, calculate(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
    @Test
    public void testDescending() {
       Assert.assertEquals(20, calculate(new int[]{8, 7, 6, 5, 4, 3, 2, 1}));
    }
    @Test
    public void testRandom() {
       Assert.assertEquals(10, calculate(new int[]{2, 1, 5, 6, 2, 3}));
    }
}