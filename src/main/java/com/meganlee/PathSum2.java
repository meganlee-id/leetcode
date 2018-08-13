package com.meganlee;

import java.util.*;

public class PathSum2 {
    //-------------------- Solution 1 --------------------//
    // use classic backtrace
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        helper(res, new ArrayList(), root, sum);
        return res;
    }

    private void helper(List<List<Integer>> result, List<Integer> path, TreeNode root, int sum) {
        // base case 1: null
        if (root == null) {
            return;
        }
        path.add(root.val);             // add current value
        // base case 2: leaf
        if (root.left == null && root.right == null) { //----- base case 2: leaf
            if (root.val == sum) {
                result.add(new ArrayList(path));
            }
        // general case
        } else {
            helper(result, path, root.left, sum - root.val);
            helper(result, path, root.right, sum - root.val);
        }
        path.remove(path.size() - 1);   // remove current value  
    }

    //-------------------- Solution 2 --------------------//
    // stack - postorder traversal
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
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
                        res.add(new ArrayList(s));
                    }
                    lastVisited = s.pop();
                    curSum -= lastVisited.val;
                // case 2: haven't visited right subtree
                } else {
                    cur = node.right;
                }
            }
        }
        return res;
    }
}

