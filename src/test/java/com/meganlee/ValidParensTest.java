package com.meganlee;

import org.junit.*;

public class ValidParensTest {
    ValidParens solution = new ValidParens();
    private boolean calculate(String s) {
        System.out.println("\n------ input string -------");
        System.out.println(s + " is valid?");
        boolean isValid = solution.isValid(s);
        System.out.println(isValid);
        return isValid;
    }

    // bad ones
    String s1 = null;           // null
    String s2 = "";             // empty
    String s3 = "({[[{";        // all open         
    String s4 = "({[[{";        // all close
    String s5 = "({}{][]}{}{";  // mixed
    // good ones
    String s6 = "()[]{}";       // sequential
    String s7 = "(([{{}}]))";   // embedded
    String s8 = "(){[]}";       // mixed

    String[] strs = {s1, s2, s3, s4, s5, s6, s7, s8};
    boolean[] res = {false, false, false, false, false, true, true, true};


    @Test
    public void testAllStrings() {
        for (int i = 0; i < strs.length; i++) {
            Assert.assertEquals(calculate(strs[i]), res[i]);         
        }
    }
}
