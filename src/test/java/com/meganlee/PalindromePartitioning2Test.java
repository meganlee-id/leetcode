package com.meganlee;

import java.util.*;
import org.junit.*;

public class PalindromePartitioning2Test {
    PalindromePartitioning2 solution = new PalindromePartitioning2();
    String s = "ababababababababababababcbabababababababababababa"; 

    @Test
    public void test() {
        Assert.assertEquals(0, solution.minCut2(s));
    }
}
