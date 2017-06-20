package com.meganlee;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    //----------------- Solution 1 --------------------//
    // recursion
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res) {
        // base case
        if (node == null) {
            return;
        }

        // general case
        res.add(node.val);       // 1. visit current node
        helper(node.left, res);  // 2. visit left subtree
        helper(node.right, res); // 3. visit right subtree
    }


    //----------------- Solution 2 --------------------//
    // Classic Stack: stack + cur pointer
    // DFS
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root == null) {
            return res;
        }
        s.push(root);
        
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            res.add(cur.val);
            if (cur.right != null) {
                s.push(cur.right);
            }
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
        return res;
    }


    //----------------- Solution 3 --------------------//
    // Morris traversal
    // pre: rightmost child of my left sub tree
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            TreeNode pre = cur.left;
            if (pre != null) {
                // find predecessor
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                // case 1: haven't visited the left subtree
                if (pre.right == null) {
                    res.add(cur.val);  // visit
                    pre.right = cur;
                    cur = cur.left;
                }
                // case 2: returned from left subtree
                if (pre.right == cur) {
                    pre.right = null;
                    cur = cur.right;
                }
            } else {
                res.add(cur.val); // visit
                cur = cur.right;
            }
        }
        return res;
    }
}

