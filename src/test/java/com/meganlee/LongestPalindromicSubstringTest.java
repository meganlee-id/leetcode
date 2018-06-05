package com.meganlee;

import org.junit.*;

public class LongestPalindromicSubstringTest {
    LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
    @Test
    public void test() {
        Assert.assertEquals(
            "sdhhds",
            solution.longestPalindrome2("sdjfeirusdhhdskj")
        );
    }
}
