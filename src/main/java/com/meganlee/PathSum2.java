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
        // base cases
        if (root == null) {
            return;
        }
        // leaf node: path has to end with a leaf node
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> newPath = new ArrayList(path);
                newPath.add(root.val);
                result.add(newPath);
            }
            return;  // remember to return here
        }
        // general case
        path.add(root.val);             // add current value
        helper(result, path, root.left, sum - root.val);
        helper(result, path, root.right, sum - root.val);
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
                // case 1: haven't visited right part
                if (node.right != null && node.right != lastVisited) {
                    cur = node.right;
                // case 2. leaf node || returned from right subtree
                } else {
                    // leaf, mark the end of a path, see if it's a valid path
                    if (node.left == null && node.right == null && curSum == sum) {
                        List<Integer> item = new ArrayList();
                        for (TreeNode n : s) {
                            item.add(n.val);
                        }
                        res.add(item);
                    }
                    // return from right sub tree
                    lastVisited = s.pop();       // pop && -cur.val
                    curSum -= lastVisited.val;
                }
            }
        }
        return res;
    }
}

