package com.meganlee;

import org.junit.*;

public class RegularExpressionMatchingTest {
    RegularExpressionMatching solution = new RegularExpressionMatching();
    private boolean calculate(String str, String pattern) {
        boolean isMatch = solution.isMatch2(str, pattern);
        System.out.println(String.format("%-10s %s", "string:",  (str == null || !str.isEmpty()) ? str : "\"\"" ));
        System.out.println(String.format("%-10s %s", "pattern:", (pattern == null || !pattern.isEmpty()) ? pattern : "\"\""));
        System.out.println(isMatch ? "Match 😁\n" : "Not Match 😰\n");
        return isMatch;
    }

    @Test
    public void testNull() {
        Assert.assertEquals(false, calculate(null, null));
        Assert.assertEquals(false, calculate(null, "abc"));
        Assert.assertEquals(false, calculate("xyz*", null));
    }

    @Test
    public void testEmpty() {
        Assert.assertEquals(true, calculate("", ""));
        Assert.assertEquals(false, calculate("abc", ""));
        Assert.assertEquals(true, calculate("", "a*.*"));
        Assert.assertEquals(false, calculate("", "a*c"));
    }

    @Test
    public void testNormal() {
        Assert.assertEquals(false, calculate("aa","a"));
        Assert.assertEquals(true, calculate("aa","aa"));
        Assert.assertEquals(false, calculate("aaa","aa"));
        Assert.assertEquals(true, calculate("aa", "a*"));
        Assert.assertEquals(true, calculate("aa", ".*"));
        Assert.assertEquals(true, calculate("ab", ".*"));
        Assert.assertEquals(true, calculate("aab", "c*a*b"));
    }
}