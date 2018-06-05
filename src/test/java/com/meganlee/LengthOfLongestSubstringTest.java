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
        Assert.assertEquals(5, calculate(s1));
    }
    @Test
    public void testS2() {
        Assert.assertEquals(12, calculate(s2));
    }
    @Test
    public void testS3() {
        Assert.assertEquals(6, calculate(s3));
    }
}