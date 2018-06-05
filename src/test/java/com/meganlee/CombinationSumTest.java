package com.meganlee;

import java.util.*;
import org.junit.*;

public class CombinationSumTest {
    CombinationSum solution = new CombinationSum();
    private String calculate(int[] nums, int target) {
        List<List<Integer>> res = solution.combinationSum(nums, target);
        System.out.println("---- inputs ----");
        System.out.println("nums: " + Arrays.toString(nums));
        System.out.println("target: " + target);
        System.out.println("---- combs ----");
        Collections.sort(res, (l1, l2) -> l1.toString().compareTo(l2.toString()));
        System.out.println(res);
        return res.toString();
    }

    int[] nums = {2, 1, 3}; int target = 3;

    @Test
    public void test() {
        Assert.assertEquals(
            "[[1, 1, 1], [1, 2], [3]]",
            calculate(nums, target)
        );
    }
}
