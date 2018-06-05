package com.meganlee;

import java.util.*;
import org.junit.*;

public class EditDistanceTest {
    EditDistance solution = new EditDistance();
    private int calculate(String s1, String s2) {
        int res = solution.minDistance(s1, s2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(res);
        return res;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, calculate("hello", "shallow"));
    }
}