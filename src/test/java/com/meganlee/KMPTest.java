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
        Assert.assertEquals(calculate(hay1, needle1), 15);
    }

    @Test
    public void test2() {
        Assert.assertEquals(calculate(hay2, needle2), 4);
    }
}
