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
    public void test() {
        Assert.assertEquals("3142", calculate(4, 14));
        Assert.assertEquals("146325879", calculate(9, 12363));
    }
}