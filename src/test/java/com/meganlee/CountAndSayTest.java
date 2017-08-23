package com.meganlee;

import org.junit.*;

public class CountAndSayTest {
    CountAndSay solution = new CountAndSay();
    private String calculate(int i) {
        String res = solution.countAndSay(i);
        System.out.println("The " + i + "th: " + res);
        return res;
    }
    int i = -1;
    String[] expected = {"", "1", "11", "21", "1211", "111221", "312211", "13112221", "1113213211", "31131211131221"};

    public void test(int i) {
        if (i < 0) {
            Assert.assertEquals(calculate(i), "");
        } else {
            Assert.assertEquals(calculate(i), expected[i]);
        }
    }

    @Test
    public void test10() {
        for (int i = -1; i < 10; i++) {
            test(i);
        }
    }
}
