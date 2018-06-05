package com.meganlee;

import java.util.*;
import org.junit.*;

public class TextJustificationTest {
    TextJustification solution = new TextJustification();
    private String calculate(String[] words, int L) {
        List<String> lines = solution.fullJustify(words, L);
        printText(lines);
        return lines.toString();
    }
    String[] words1 = {"What","must","be","shall","be."};
    String[] words2 = {"This", "is", "an", "example", "of", "text", "justification."};
    String[] words3 = {""};

    private void printText(List<String> lines) {
        System.out.println("12345678901234567890");  // ruler
        for (String line: lines) {
            System.out.println(line + "#");
        }
        System.out.println();
    }

    @Test
    public void testWords1With6() {
        Assert.assertEquals(
            "[What  , must  , be    , shall , be.   ]",
            calculate(words1, 6)
        );
    }

    @Test
    public void testWords1With10() {
        Assert.assertEquals(
            "[What  must, be   shall, be.       ]",
            calculate(words1, 10)
        );
    }

    @Test
    public void testWords1With12() {
        Assert.assertEquals(
            "[What must be, shall be.   ]",
            calculate(words1, 12)
        );
    }

    @Test
    public void testWords1With18() {
        Assert.assertEquals(
            "[What must be shall, be.               ]",
            calculate(words1, 18)
        );
    }

    @Test
    public void testWords2With15() {
        Assert.assertEquals(
            "[This    is   an, example of text, justification. ]",
            calculate(words2, 15)
        );
    }

    @Test
    public void testWords3With0() {
        Assert.assertEquals(
            "[]", 
            calculate(words3, 0)
        );
    }
}
