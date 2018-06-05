package com.meganlee;

import java.util.*;
import org.junit.*;

public class ScrambleStringTest {
    ScrambleString solution = new ScrambleString();
    private boolean calculate(String s1, String s2) {
        boolean res = solution.isScramble2(s1, s2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(res + "\n");
        return res;
    }

    @Test
    public void test() {
        Assert.assertEquals(true, calculate("great", "aterg"));
        Assert.assertEquals(true, calculate("xxxyyy", "yyxxyx"));
        Assert.assertEquals(false, calculate("xxxyyy", "yyxzyx"));
        Assert.assertEquals(true, calculate("ab", "ba"));
    }
}