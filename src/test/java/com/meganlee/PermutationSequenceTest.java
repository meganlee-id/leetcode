package com.meganlee;

import java.util.*;
import org.junit.*;

public class PermutationSequenceTest {
    PermutationSequence solution = new PermutationSequence();
    private String calculate(int n, int k) {
        String res = solution.getPermutation(n, k);
        return res;
    }

    @Test
    public void testEmptyArray() {
        Assert.assertEquals(calculate(9, 12363), "146325879");
    }
}