package com.meganlee;

public class MaxPathSum {
    int globaMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return globaMax;
    }
    
    private int maxPathDown(TreeNode node) {
        // base case
        if (node == null) return 0;
        // general case
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        globaMax = Math.max(globaMax, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}

// NOTE 1: max sum could be negative!!!
//   do remember to add max[0] = Integer.MIN_VALUE;
//   Input:  {-3}
//   Output:    0
//   Expected:  3
