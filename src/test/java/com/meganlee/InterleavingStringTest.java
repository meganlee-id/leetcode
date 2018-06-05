package com.meganlee;

import java.util.*;
import org.junit.*;

public class InterleavingStringTest {
    InterleavingString solution = new InterleavingString();
    private boolean calculate(String s1, String s2, String s3) {
        boolean res = solution.isInterleave3(s1, s2, s3);
        System.out.println(String.format("s1: %s, s2: %s", s1, s2));
        System.out.println("s3: " + s3);
        System.out.println(res + "\n");
        return res;
    }

    @Test
    public void test() {
        Assert.assertEquals(
            true,  
            calculate("aabcc", "dbbca", "aadbbcbcac")
        );
        Assert.assertEquals(
            false, 
            calculate("aabcc", "dbbca", "aadbbbaccc")
        );
        Assert.assertEquals(
            false, 
            calculate(
              "cacbbbaaabbacbbbbabbcaccccabaaacacbcaacababbaabbaccacbaabac",
              "cbcccabbbbaaacbaccbabaabbccbbbabacbaacccbbcaabaabbbcbcbab",
              "ccbcccacbabbbbbbaaaaabbaaccbabbbbacbcbcbaacccbacabbaccbaaabcacbbcabaabacbbcaacaccbbacaabababaabbbaccbbcacbbacabbaacb"
            )
        );
    }
}
