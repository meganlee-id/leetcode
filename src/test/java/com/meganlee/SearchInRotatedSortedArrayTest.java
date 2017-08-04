package com.meganlee;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrayTest {
    SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int[] arr1 = {4, 5, 0, 1, 2, 3};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        private int calculate(int[] nums, int target) {
        return solution.search(nums, target);
    }

    @Test
    public void testSearch3InArr1() {
        Assert.assertEquals(5, calculate(arr1, 3));
    }
    @Test
    public void testSearch5InArr1() {
        Assert.assertEquals(1, calculate(arr1, 5));
    }
    @Test
    public void testSearch6InArr1() {
        Assert.assertEquals(-1, calculate(arr1, 6));
    }

    @Test
    public void testSearch3InArr2() {
        Assert.assertEquals(2, calculate(arr2, 3));
    }
    @Test
    public void testSearch5InArr2() {
        Assert.assertEquals(4, calculate(arr2, 5));
    }
    @Test
    public void testSearch6InArr2() {
        Assert.assertEquals(5, calculate(arr2, 6));
    }
}