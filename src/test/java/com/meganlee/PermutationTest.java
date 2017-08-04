package com.meganlee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PermutationTest {
    Permutation solution = new Permutation();
    private String calculate(int[] num) {
        List<List<Integer>> res = solution.permute(num);
        // sort for better comparison
        Collections.sort(res, (l1, l2) -> l1.toString().compareTo(l2.toString()));
        return res.toString();
    }

    int[] a0 = {};
    int[] a1 = {1, 2, 3};
    int[] a2 = {4, 3, 2, 1};
    int[] a3 = {5, 3, 9};

    @Test
    public void testEmptyArray() {
        Assert.assertEquals(calculate(a0), "[]");
    }

    @Test
    public void testAscendingArray() {
        Assert.assertEquals(calculate(a1), "[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]");
    }

    @Test
    public void testDescendingArray() {
        Assert.assertEquals(calculate(a2), "[[1, 2, 3, 4], [1, 2, 4, 3], [1, 3, 2, 4], [1, 3, 4, 2], [1, 4, 2, 3], [1, 4, 3, 2], [2, 1, 3, 4], [2, 1, 4, 3], [2, 3, 1, 4], [2, 3, 4, 1], [2, 4, 1, 3], [2, 4, 3, 1], [3, 1, 2, 4], [3, 1, 4, 2], [3, 2, 1, 4], [3, 2, 4, 1], [3, 4, 1, 2], [3, 4, 2, 1], [4, 1, 2, 3], [4, 1, 3, 2], [4, 2, 1, 3], [4, 2, 3, 1], [4, 3, 1, 2], [4, 3, 2, 1]]");
    }

    @Test
    public void testRandomArray() {
        Assert.assertEquals(calculate(a3), "[[3, 5, 9], [3, 9, 5], [5, 3, 9], [5, 9, 3], [9, 3, 5], [9, 5, 3]]");
    }
}