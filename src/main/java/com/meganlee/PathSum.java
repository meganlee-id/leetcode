package com.meganlee;

import java.util.*;

public class PathSum {
    //------------------- Solution 1 --------------------//
    // Back-tracking
    public boolean hasPathSum(TreeNode root, int sum) {
        // base case 1: null
        if (root == null) {
            return false;
        } 
        // base case 2: leaf
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        // general case
        return hasPathSum(root.left,  sum - root.val) || 
               hasPathSum(root.right, sum - root.val);
    }

    //------------------- Solution 2 --------------------//
    // Classic Stack: stack + cur + lastVisited
    public boolean hasPathSum2(TreeNode root, int sum) {
        Stack<TreeNode> s = new Stack();
        TreeNode cur = root, lastVisited = null;
        int curSum = 0;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {  //--- GOING DOWN ---
                s.push(cur);        // add to call stack && + cur.val
                curSum += cur.val;
                cur = cur.left;
            } else {            //--- GOING UP   ---
                TreeNode node = s.peek();
                // case 1: right subtree visited already
                if (node.right == null || node.right == lastVisited) {
                    if (node.left == null && node.right == null && curSum == sum) { // leaf and right sum
                        return true;
                    }
                    lastVisited = s.pop();      // pop && -cur.val
                    curSum -= lastVisited.val;
                // case 2: haven't visited right subtree
                } else {
                    cur = node.right;
                }
            }
        }
        return false;
    }
}
