package com.meganlee;

import org.junit.*;

public class PalindromeNumberTest {
    PalindromeNumber solution = new PalindromeNumber();
    private boolean calculate(int n) {
        System.out.println("\n------ input string -------");
        System.out.println(n + " is valid palindrome number?");
        boolean isValid = solution.isPalindrome(n);
        System.out.println(isValid);
        return isValid;
    }

    int n1 = 0;
    int n2 = -0;
    int n3 = -1221;
    int n4 = 1221;
    int n5 = 12212;
    int n6 = +1221;

    @Test
    public void test() {
        Assert.assertEquals(true, calculate(n1));
        Assert.assertEquals(true, calculate(n2));
        Assert.assertEquals(false, calculate(n3));
        Assert.assertEquals(true, calculate(n4));
        Assert.assertEquals(false, calculate(n5));
        Assert.assertEquals(true, calculate(n6));
    }
}
