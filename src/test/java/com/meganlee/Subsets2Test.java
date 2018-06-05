package com.meganlee;

import java.util.*;
import org.junit.*;

public class Subsets2Test {
    Subsets2 solution = new Subsets2();
    private String calculate(int[] s) {
        List<List<Integer>> res = solution.subsetsWithDup(s);
        Collections.sort(res, (l1, l2) -> l1.toString().compareTo(l2.toString()));
        System.out.println(Arrays.toString(s));
        System.out.println(res);
        return res.toString();
    }

    int[] s = {1,4,4};

    @Test
    public void test() {
        Assert.assertEquals(
            "[[1, 4, 4], [1, 4], [1], [4, 4], [4], []]",
            calculate(s)
        );
    }
}
