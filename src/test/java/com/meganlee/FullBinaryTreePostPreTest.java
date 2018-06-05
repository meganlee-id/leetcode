package com.meganlee;

import org.junit.*;

public class FullBinaryTreePostPreTest {
    FullBinaryTreePostPre solution = new FullBinaryTreePostPre();
    public String calculate(int[] pre, int[] post) {
        int len = pre.length;
        FullBinaryTreePostPre.Node root = solution.constructTreeUtil(pre, 0, len - 1, post, 0, len - 1);
        StringBuilder sb = new StringBuilder();
        FullBinaryTreePostPre.printInorder(root, sb);
        return sb.toString();
    }

    int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
    int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };

    @Test
    public void test() {
       Assert.assertEquals("8 4 9 2 5 1 6 3 7 ", calculate(pre, post));
    }
}