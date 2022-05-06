package com.meganlee;

import java.util.*;

public class ValidateBinarySearchTree {
    //------------------- Solution 1 -----------------------//
    // recursion + pass range down
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode cur, TreeNode min, TreeNode max) {
        // Base Case
        if (cur == null) {
            return true;
        }
        // General Case
        // 1. check root
        if ((min != null && min.val >= cur.val) || 
            (max != null && max.val <= cur.val)) {
            return false;
        // 2. check 2 subtrees
        } else {
            return helper(cur.left, min, cur) && helper(cur.right, cur, max);
        }
    }

    //------------------- Solution 2 -----------------------//
    // in-order traversal: cur + stack
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        TreeNode pre = null;        // use a preNode
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) { //------ GOING DOWN
                s.push(cur);     // push
                cur = cur.left;  // left
            } else {           //------ GOING up
                TreeNode node = s.pop(); // pop
                // VISIT
                if (pre != null && pre.val >= node.val) {
                    return false; // pre >= cur
                } else {
                    pre = node; // update pre
                } 
                cur = node.right;   // right
            }
        }
        return true;
    }
}
