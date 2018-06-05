package com.meganlee;

import org.junit.*;

public class WildcardMatchingTest {
    WildcardMatching solution = new WildcardMatching();
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
        Assert.assertEquals(true, calculate("", "*"));
        Assert.assertEquals(false, calculate("abc", ""));
    }

    @Test
    public void testNormal() {
        Assert.assertEquals(true, calculate("", "*"));
        Assert.assertEquals(false, calculate("abcad", "a*cb**?"));
        Assert.assertEquals(true, calculate("abbbbm", "*?"));
        Assert.assertEquals(false, calculate("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
        Assert.assertEquals(true, calculate("ab", "*"));
        Assert.assertEquals(true, calculate("ab", "?*"));
        Assert.assertEquals(false, calculate("aab", "c?a*b*"));
        Assert.assertEquals(true, calculate("cabab", "*ab"));
        Assert.assertEquals(false, calculate("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
        Assert.assertEquals(false, calculate("bbaabbbabbbbabbbaaabababbbabbababbbabaaabbbbaabaabaaaa", "*b**b*a**abbaab*aba***"));
    }
}