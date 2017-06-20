package com.meganlee;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    //----------------- Solution 1 ------------------//
    // recursion
    public List<Integer> inorderTraversal(TreeNode root) {
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
        helper(node.left, res);  // 1. visit left subtree
        res.add(node.val);       // 2. visit current node
        helper(node.right, res); // 3. visit right subtree
    }


    //----------------- Solution 2 ------------------//
    // Classic Stack: stack + cur pointer
    // post
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) { // travel to each node's left child, till reach the left leaf
                s.push(cur);
                cur = cur.left;
            } 
            cur = s.pop();        // backtrack to higher level node A
            res.add(cur.val);     // add the node to the result list
            cur = cur.right;      // switch to A'right branch
        }
        return res;
    }

    
    //----------------- Solution 3 ------------------//
    // Morris traversal
    // pre: rightmost child of my left sub tree
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
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
                    res.add(cur.val);  // visit
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


    /////////////////  TEST  //////////////////
    public static void main(String[] args) {
        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        String[] s = {"1", "2", "3", "#", "#", "4", "#", "#", "5"};
        TreeNode root = TreeNode.buildTree(s);
        List<Integer> result = solution.inorderTraversal3(root);
        PrettyPrinter.print1DList(result);
    }
}