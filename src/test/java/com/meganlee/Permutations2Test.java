package com.meganlee;

import java.util.*;
import org.junit.*;

public class Permutations2Test {
    Permutations2 solution = new Permutations2();
    private String calculate(int[] a) {
        System.out.println("---- input ----");
        Arrays.toString(a);

        System.out.println("---- permutations ----");
        List<List<Integer>> res = solution.permuteUnique(a);
        PrettyPrinter.print2DIntList(res);
        
        return res.toString();
    }

    int[] a1 = {1, 1, 2, 3};
    int[] a2 = {1, 2, 2, 2};

    @Test
    public void testCase1() {
        Assert.assertEquals(
           // [1, 1, 2, 3], 
           // [1, 1, 3, 2], 
           // [1, 2, 1, 3], 
           // [1, 2, 3, 1], 
           // [1, 3, 2, 1], 
           // [1, 3, 1, 2], 
           // [2, 1, 1, 3], 
           // [2, 1, 3, 1], 
           // [2, 3, 1, 1], 
           // [3, 1, 2, 1], 
           // [3, 1, 1, 2], 
           // [3, 2, 1, 1]
            "[[1, 1, 2, 3], [1, 1, 3, 2], [1, 2, 1, 3], [1, 2, 3, 1], [1, 3, 2, 1], [1, 3, 1, 2], [2, 1, 1, 3], [2, 1, 3, 1], [2, 3, 1, 1], [3, 1, 2, 1], [3, 1, 1, 2], [3, 2, 1, 1]]", 
            calculate(a1)
        );
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(
            // [1, 2, 2, 2], 
            // [2, 1, 2, 2], 
            // [2, 2, 1, 2], 
            // [2, 2, 2, 1]
            "[[1, 2, 2, 2], [2, 1, 2, 2], [2, 2, 1, 2], [2, 2, 2, 1]]", 
            calculate(a2)
        );
    }
}