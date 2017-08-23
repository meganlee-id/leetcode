package com.meganlee;

import org.junit.*;

public class MinimumWindowSubstringTest {
    MinimumWindowSubstring solution = new MinimumWindowSubstring();
    private String calculate(String s, String t) {
        return s = solution.minWindow(s, t);
    }
    String s1 = "bddab", t1 = "ab";
    String s2 = "bba", t2 = "ab";

    @Test
    public void testCase1() {
        Assert.assertEquals(calculate(s1, t1), "ab");
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(calculate(s2, t2), "ba");
    }
}