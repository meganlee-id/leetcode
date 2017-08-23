package com.meganlee;

import java.util.*;
import org.junit.*;

public class ConstructPreorderInorderTest {
    ConstructPreorderInorder solution = new ConstructPreorderInorder();
    private String calculate(int[] pre, int[] in) {
        BinaryTreeInorderTraversal util = new BinaryTreeInorderTraversal();
        List<Integer> actual = util.inorderTraversal(solution.buildTree(pre, in));
        return actual.toString();
    }

    int[] preorder = {7, 10, 4, 3, 1, 2, 8, 11};
    int[] inorder  = {4, 10, 3, 1, 7, 11, 8, 2};

    @Test
    public void test() {
        Assert.assertEquals(calculate(preorder, inorder), "[4, 10, 3, 1, 7, 11, 8, 2]");
    }
}
