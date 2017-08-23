package com.meganlee;

import org.junit.*;

public class LongestValidParenthesesTest {
    LongestValidParentheses solution = new LongestValidParentheses();
    private int calculate(String s) {
        return solution.longestValidParentheses(s);
    }
    String s1 = "()(()";
    String s2 = "()(())";
    String s3 = "()(()))";

    @Test
    public void testS1() {
        Assert.assertEquals(calculate(s1), 2);
    }
    @Test
    public void testS2() {
        Assert.assertEquals(calculate(s2), 6);
    }
    @Test
    public void testS3() {
        Assert.assertEquals(calculate(s3), 6);
    }
}