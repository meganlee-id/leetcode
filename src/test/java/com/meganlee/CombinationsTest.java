package com.meganlee;

import java.util.*;
import org.junit.*;

public class CombinationsTest {
    Combinations solution = new Combinations();
    private String calculate(int n, int k) {
        List<List<Integer>> res = solution.combine2(n, k);
        System.out.println("n=" + n + ", k=" + k);
        PrettyPrinter.print2DIntList(res);
        System.out.println();
        Collections.sort(res, (l1, l2) -> l1.toString().compareTo(l2.toString()));
        return res.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals(
            "[[1, 2], [1, 3], [2, 3]]",
            calculate(3, 2)
        );
        Assert.assertEquals(
            "[[1, 2, 3, 4], [1, 2, 3, 5], [1, 2, 3, 6], [1, 2, 4, 5], [1, 2, 4, 6], [1, 2, 5, 6], [1, 3, 4, 5], [1, 3, 4, 6], [1, 3, 5, 6], [1, 4, 5, 6], [2, 3, 4, 5], [2, 3, 4, 6], [2, 3, 5, 6], [2, 4, 5, 6], [3, 4, 5, 6]]",
            calculate(6, 4)
        );
    }
}
