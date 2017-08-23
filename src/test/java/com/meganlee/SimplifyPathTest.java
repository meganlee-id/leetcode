package com.meganlee;

import org.junit.*;

public class SimplifyPathTest {
    SimplifyPath solution = new SimplifyPath();
    private String calculate(String s) {
        System.out.println("str: " + s);
        String[] splitted = s.split("/");
        System.out.print("splits: "); 
        PrettyPrinter.print1DStrArray(splitted);
        String res = solution.simplifyPath(s);
        System.out.print("simplified path: "); 
        System.out.println(res);
        System.out.println();
        return res;
    }
    String[] inputs = { "///./../a///b/k///",
                        "/..",
                        "",
                        "/..///a/./../b/c//" };
    String[] outputs = {"/a/b/k",
                        "/",
                        "",
                        "/b/c"};
    @Test
    public void testLoop() {
        for (int i = 0; i < inputs.length; i++) {
            Assert.assertEquals(calculate(inputs[i]), outputs[i]);
        }
    }
}
