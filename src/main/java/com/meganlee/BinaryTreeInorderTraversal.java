package com.meganlee;

import java.util.*;

public class BinaryTreeInorderTraversal {
    //----------------- Solution 1 ------------------//
    // recursion
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        helper(root, res);
        return res;
    }
    private void helper(TreeNode node, List<Integer> res) {
        // base case
        if (node == null) {
            return;
        }
        // general case
        helper(node.left, res);  // 1. visit left subtree
        res.add(node.val);       // 2. visit current node
        helper(node.right, res); // 3. visit right subtree
    }

    //----------------- Solution 2 ------------------//
    // Classic Stack: stack + cur pointer
    // Ask: whether to returen a List<TreeNode> or List<Integer>
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> s = new Stack();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {  //--- GOING DOWN ---
                s.push(cur);        // push
                cur = cur.left;     // left
            } else {            //--- GOING UP   ---
                TreeNode node = s.pop();  // pop
                res.add(node.val);        // VISIT
                cur = node.right;         // right
            }
        }
        return res;
    }

    //----------------- Solution 3 ------------------//
    //-- NO DFS SOLUTION FOR IN-ORDER TRAVERSAL
    

    //----------------- Solution 4 ------------------//
    // Morris traversal
    // pre: rightmost child of my left sub tree
    public List<Integer> inorderTraversal4(TreeNode root) {
        List<Integer> res = new ArrayList();
        TreeNode cur = root;
        while (cur != null) {
            TreeNode pre = cur.left;
            if (pre != null) {
                // find predecessor
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                // case 1: haven't visited left subtree
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                // case 2: returned from left subtree
                if (pre.right == cur) {
                    res.add(cur.val);  // VISIT
                    pre.right = null;
                    cur = cur.right;
                }
            } else {
                res.add(cur.val); // VISIT
                cur = cur.right;
            }
        }
        return res;
    }
}
