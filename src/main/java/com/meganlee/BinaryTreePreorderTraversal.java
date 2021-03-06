package com.meganlee;

import java.util.*;

public class BinaryTreePreorderTraversal {

    //----------------- Solution 1 --------------------//
    // recursion
    public List<Integer> preorderTraversal(TreeNode root) {
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
        res.add(node.val);       // 1. visit current node
        helper(node.left, res);  // 2. visit left subtree
        helper(node.right, res); // 3. visit right subtree
    }

    //----------------- Solution 2 --------------------//
    // Classic Stack: stack + cur
    // Ask: whether to returen a List<TreeNode> or List<Integer>
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> s = new Stack();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {  //--- GOING DOWN ---
                s.push(cur);        // push
                res.add(cur.val);   // VISIT
                cur = cur.left;     // left
            } else {            //--- GOING UP   ---
                TreeNode node = s.pop();  // pop
                cur = node.right;         // right
             }
        }
        return res;
    }


    //----------------- Solution 3 --------------------//
    // DFS
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> s = new Stack();
        if (root == null) {
            return res;
        }
        s.push(root);
        
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            res.add(cur.val);
            // push right node first which will be visited laster
            if (cur.right != null) {
                s.push(cur.right);
            }
            if (cur.left != null) {
                s.push(cur.left);
            }
        }
        return res;
    }


    //----------------- Solution 4 --------------------//
    // Morris traversal
    // pre: rightmost child of my left sub tree
    public List<Integer> preorderTraversal4(TreeNode root) {
        List<Integer> res = new ArrayList();
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
                    res.add(cur.val);  // VISIT
                    pre.right = cur;   // connect
                    cur = cur.left;    // left
                }
                // case 2: returned from left subtree
                if (pre.right == cur) {
                    pre.right = null;  // disconnect
                    cur = cur.right;   // right
                }
            } else {
                res.add(cur.val); // VISIT
                cur = cur.right;
            }
        }
        return res;
    }
}

