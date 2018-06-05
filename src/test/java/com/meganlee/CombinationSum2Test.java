package com.meganlee;

import java.util.*;
import org.junit.*;

public class CombinationSum2Test {
    CombinationSum2 solution = new CombinationSum2();
    private String calculate(int[] nums, int target) {
        List<List<Integer>> res = solution.combinationSum2(nums, target);
        System.out.println("---- inputs ----");
        System.out.println("nums: " + Arrays.toString(nums));
        System.out.println("target: " + target);
        System.out.println("---- combs ----");
        Collections.sort(res, (l1, l2) -> l1.toString().compareTo(l2.toString()));
        System.out.println(res);
        return res.toString();
    }

    int[] nums = {10,1,1,1,2,7,6,5};
    int target = 8;

    @Test
    public void test() {
        Assert.assertEquals(
            "[[1, 1, 1, 5], [1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]",
            calculate(nums, target)
        );
    }
}
