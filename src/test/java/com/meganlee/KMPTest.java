package com.meganlee;

import java.util.*;
import org.junit.*;

public class KMPTest {
    KMP solution = new KMP();
    private int calculate(String h, String n) {
        return solution.strStr(h, n);
    }
    String hay1 = "ABC ABCDAB ABCDABCDABDE";
    String needle1 = "ABCDABD";

    String hay2 = "aabaaabaaac";
    String needle2 = "aabaaac";

    @Test
    public void test1() {
        Assert.assertEquals(15, calculate(hay1, needle1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, calculate(hay2, needle2));
    }
}
