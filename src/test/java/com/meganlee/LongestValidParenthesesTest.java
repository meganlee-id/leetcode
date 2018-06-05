package com.meganlee;

import org.junit.*;

public class LongestValidParenthesesTest {
    LongestValidParentheses solution = new LongestValidParentheses();
    private int calculate(String s) {
        return solution.longestValidParentheses(s);
    }
    String s1 = null;
    String s2 = "";
    String s3 = "(";
    String s4 = ")";
    String s5 = ")(";
    String s6 = "()";
    String s7 = "(()";
    String s8 = "(())";
    String s9 = "()(()";
    String s10 = "()(())";
    String s11 = "()(()))";

    @Test
    public void test() {
        Assert.assertEquals(0, calculate(s1));
        Assert.assertEquals(0, calculate(s2));
        Assert.assertEquals(0, calculate(s3));
        Assert.assertEquals(0, calculate(s4));
        Assert.assertEquals(0, calculate(s5));
        Assert.assertEquals(2, calculate(s6));
        Assert.assertEquals(2, calculate(s7));
        Assert.assertEquals(4, calculate(s8));
        Assert.assertEquals(2, calculate(s9));
        Assert.assertEquals(6, calculate(s10));
        Assert.assertEquals(6, calculate(s11));
    }
}