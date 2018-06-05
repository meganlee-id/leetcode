package com.meganlee;

import org.junit.*;

public class BinaryTreeInorderTraversalTest {
    BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
    String[] s = {"1", "2", "3", "#", "#", "4", "#", "#", "5"};
    TreeNode root = TreeNode.buildTreeFromLevelOrder(s);

    private String calculate(TreeNode root) {
        return solution.inorderTraversal4(root).toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("[2, 1, 4, 5, 3]", calculate(root));
    }
}