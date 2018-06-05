
package com.meganlee;

import java.util.*;
import org.junit.*;

public class SubsetsTest {
    Subsets solution = new Subsets();
    private String calculate(int[] s) {
        List<List<Integer>> res = solution.subsets(s);
        Collections.sort(res, (l1, l2) -> l1.toString().compareTo(l2.toString()));
        System.out.println(Arrays.toString(s));
        System.out.println(res);
        return res.toString();
    }

    int[] s = {1,3,4};

    @Test
    public void test() {
        Assert.assertEquals(
            "[[1, 3, 4], [1, 3], [1, 4], [1], [3, 4], [3], [4], []]",
            calculate(s)
        );
    }
}
