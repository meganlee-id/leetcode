package com.meganlee;

import org.junit.Assert;
import org.junit.Test;

// org.junit.Assert.assertEquals(float1, float2, delta);

public class MedianOfTwoSortedArrayTest {
    MedianOfTwoSortedArray solution = new MedianOfTwoSortedArray();
    private double calculate(int[] A, int[] B) {
       return solution.findMedianSortedArrays2(A, B);
    }
    double delta = 1e-10;

    @Test
    public void test1() {
       Assert.assertEquals(1.0, calculate(new int[]{}, new int[]{1}), delta);
    }
    @Test
    public void test2() {
       Assert.assertEquals(1.0, calculate(new int[]{1}, new int[]{1}), delta);
    }
    @Test
    public void test3() {
       Assert.assertEquals(3.0, calculate(new int[]{1, 2}, new int[]{3, 6, 8}), delta);
    }
    @Test
    public void test4() {
       Assert.assertEquals(4.5, calculate(new int[]{1, 2, 9}, new int[]{3, 6, 8}), delta);
    }
}