package com.meganlee;

import java.util.*;
import org.junit.*;

public class SimplifyPathTest {
    SimplifyPath solution = new SimplifyPath();
    private String calculate(String s) {
        System.out.println("str: " + s);
        String[] splitted = s.split("/");
        System.out.print("splits: "); 
        System.out.println(Arrays.toString(splitted));
        String res = solution.simplifyPath(s);
        System.out.print("simplified path: "); 
        System.out.println(res);
        System.out.println();
        return res;
    }
    String[] inputs = { "///./../a///b/k///",
                        "/..",
                        "",
                        "/..///a/./../b/c//",
                        "a/c"};
    String[] outputs = {"/a/b/k",
                        "/",
                        "",
                        "/b/c",
                        ""};
    @Test
    public void testLoop() {
        for (int i = 0; i < inputs.length; i++) {
            Assert.assertEquals(outputs[i], calculate(inputs[i]));
        }
    }
}
