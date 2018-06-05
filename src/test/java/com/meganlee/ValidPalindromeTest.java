package com.meganlee;

import org.junit.*;

public class ValidPalindromeTest {
    ValidPalindrome solution = new ValidPalindrome();
    private boolean calculate(String s) {
        System.out.println("\n------ input string -------");
        System.out.println(s + " is valid palindrome?");
        boolean isValid = solution.isPalindrome(s);
        System.out.println(isValid);
        return isValid;
    }

    String input = "A man, a plan, a canal: Panama";

    @Test
    public void test() {
        Assert.assertEquals(true, calculate(input));
    }
}
