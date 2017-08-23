package com.meganlee;

import java.util.*;

public class PathSum {
    //------------------- Solution 1 --------------------//
    // Back-tracking
    public boolean hasPathSum(TreeNode root, int sum) {
        // base case: either root itself is null or it's a leave's child node
        if (root == null) {
            return false;
        }
        // leaf node: path has to end with a leaf node
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        // general case
        int leftover = sum - root.val;
        return hasPathSum(root.left, leftover) || hasPathSum(root.right, leftover);
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
                // case 1: haven't visited right part
                if (node.right != null && node.right != lastVisited) {
                    cur = node.right;
                // case 2. leaf node || returned from right subtree
                } else {
                    // leaf, mark the end of a path, see if it's a valid path
                    if (node.left == null && node.right == null && curSum == sum) {
                        return true;
                    }
                    // return from right sub tree
                    lastVisited = s.pop();      // pop && -cur.val
                    curSum -= lastVisited.val;
                }
            }
        }
        return false;
    }
}
