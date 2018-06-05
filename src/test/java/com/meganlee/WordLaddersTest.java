package com.meganlee;

import java.util.*;
import org.junit.*;

public class WordLaddersTest {
    WordLadders solution = new WordLadders();
    private int calculate(String start, String end, List<String> dict) {
        return solution.ladderLength2(start, end, dict);
    }

    List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log");
    Set<String> dict = new HashSet(list);

    @Test
    public void test() {
        Assert.assertEquals(0, calculate("hit", "cog", list));
    }
}