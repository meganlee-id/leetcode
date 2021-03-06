package com.meganlee;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    private int height(TreeNode cur) {
        // base case 
        if (cur == null) {
            return 0;
        }
        // general case
        int leftH  = height(cur.left);
        int rightH = height(cur.right);
        if (leftH == -1 || rightH == -1 || Math.abs(leftH - rightH) > 1) {
            return -1;  // if tree not balanced return -1;
        } else {
            return Math.max(leftH, rightH) + 1; // other wise return height of tree
        }
    }
}

