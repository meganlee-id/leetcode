package com.meganlee;

public class FlattenBinaryTree {
    //--------------- Solution 1 ---------------//
    // Pre-Order recursion
    private TreeNode pre = null;  // if we need to call flattern multiple times, need to clear this
    public void flatten(TreeNode root) {
        // Base Case
        if (root == null) {
            return;
        }
        // General Case
        // 1. visit cur
        if (pre != null) {  // connect previous node to this node
            pre.left = null;
            pre.right = root;
        }
        pre = root; // update pre
        // save right node otherwise it'll change
        TreeNode right = root.right;
        // 2. visit left
        flatten(root.left);
        // 3. visit right
        flatten(right);
    }

    //--------------- Solution 1 ---------------//
    // Mirror-Tree Post-Order recursion
    private TreeNode post = null;  // if we need to call flattern multiple times, need to clear this
    public void flatten2(TreeNode root) {
        // Base Case
        if (root == null) {
            return;
        }
        // General Case
        // 1. visit right
        flatten(root.right);
        // 2. visit left
        flatten(root.left);
        // 3. visit cur
        root.left = null;
        root.right = post;
        post = root;
    }
}

