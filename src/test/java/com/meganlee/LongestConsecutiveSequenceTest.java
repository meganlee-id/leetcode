package com.meganlee;

import java.util.*;
import org.junit.*;

public class LongestConsecutiveSequenceTest {
    LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
    private int calculate(int[] nums) {
        int res = solution.longestConsecutive(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
        return res;
    }

    int[] nums1 = null;
    int[] nums2 = {};
    int[] nums3 = {0, -1};
    int[] nums4 = {4, 3, 5, -1, 0, 3, 7, 8, 9, -2, 10};


    @Test
    public void test() {
        Assert.assertEquals(calculate(nums1), 0);
        Assert.assertEquals(calculate(nums2), 0);
        Assert.assertEquals(calculate(nums3), 2);
        Assert.assertEquals(calculate(nums4), 4);
    }
}