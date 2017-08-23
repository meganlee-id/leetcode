package com.meganlee;

import org.junit.*;

public class LengthOfLongestSubstringTest {
    LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
    private int calculate(String s) {
        return solution.lengthOfLongestSubstring(s);
    }
    String s1 = "bbmqbwkkyh";
    String s2 = "qopubjguxhxdipfzwswybgfylqvjzhar";
    String s3 = "opubpubxyz";

    @Test
    public void testS1() {
        Assert.assertEquals(calculate(s1), 5);
    }
    @Test
    public void testS2() {
        Assert.assertEquals(calculate(s2), 12);
    }
    @Test
    public void testS3() {
        Assert.assertEquals(calculate(s3), 6);
    }
}