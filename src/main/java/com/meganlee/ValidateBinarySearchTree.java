package com.meganlee;

import java.util.*;

public class ValidateBinarySearchTree {
    //------------------- Solution 1 -----------------------//
    // recursion + pass range down
    public boolean isValidBST1(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode cur, TreeNode min, TreeNode max) {
        // Base Case
        if (cur == null) {
            return true;
        }
        
        // General Case
        // --1. check if cur value is in range
        if ((min != null && min.val >= cur.val) || (max != null && max.val <= cur.val)) {
            return false;
        }
        
        // --2. check two subtrees
        return helper(cur.left, min, cur) && helper(cur.right, cur, max);
    }


    //------------------- Solution 2 -----------------------//
    // in-order traversal: stack + cur
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        TreeNode pre = null;      // use a preNode
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) { // travel to each node's left child, till reach the left leaf
                s.push(cur);
                cur = cur.left;
            } 
            cur = s.pop();        // backtrack to higher level node A
            // ------ VISIT ------
            if (pre != null && pre.val >= cur.val) {
                return false;
            } else {
                pre = cur;
            }
            //--------------------
            cur = cur.right;      // switch to A'right branch
        }
        return true;
    }
}
