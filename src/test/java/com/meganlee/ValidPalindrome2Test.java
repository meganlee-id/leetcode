package com.meganlee;

import org.junit.*;

public class ValidPalindrome2Test {
    ValidPalindrome2 solution = new ValidPalindrome2();
    private boolean calculate(String s) {
        System.out.println("\n------ input string -------");
        System.out.println(String.format("\"%s\" is valid palindrome after at most 1 delete?", s));
        boolean isValid = solution.validPalindrome2(s);
        System.out.println(isValid);
        return isValid;
    }

    String s1 = "abca";
    String s2 = "aabcba";
    String s3 = "aabcxba";

    @Test
    public void test() {
        Assert.assertEquals(true, calculate(s1));
        Assert.assertEquals(true, calculate(s2));
        Assert.assertEquals(false, calculate(s3));
    }
}
