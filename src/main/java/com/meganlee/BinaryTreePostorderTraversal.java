package com.meganlee;

import java.util.*;

public class BinaryTreePostorderTraversal {

    //--------------------- Solution 1 ----------------------//
    // recursion
    public List<Integer> postorderTraversal(TreeNode root) {
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
        helper(node.right, res); // 2. visit right subtree
        res.add(node.val);       // 3. visit current node
    }


    //--------------------- Solution 2 ----------------------//
    // We could also use reverse preorder, here is a tweak version of classic stack
    // stack + cur + lastVisited
    // Stack always store the path from root to current
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> s = new Stack();
        TreeNode cur = root, lastVisited = null;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {  //--- GOING DOWN ---
                s.push(cur);        // add to call stack
                cur = cur.left;     // travel to each node's left child, till reach the left leaf
            } else {            //--- GOING UP   ---
                TreeNode node = s.peek();
                // case 1: right subtree visited already
                if (node.right == null || node.right == lastVisited) {
                    lastVisited = s.pop();    // backtrack to higher level
                    res.add(lastVisited.val); // visit
                // case 2: haven't visited right subtree
                } else {
                    cur = node.right;          // switch to right branch
                }
            }
        }
        return res;
    }

    //--------------------- Solution 3 ----------------------//
    // DFS (Reverse of preorder traversal of mirrored original tree)
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> s = new Stack();
        if (root == null) {
            return res;
        }
        s.push(root);
        
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            res.add(cur.val);
            if (cur.left != null) {
                s.push(cur.left);
            }
            if (cur.right != null) {
                s.push(cur.right);
            } 
        }
        // if we define res as LinkedList: LinkedList<Integer> res = new LinkedList();
        // and use res.addFirst(cur.val) at line 43, we culd skip this reverse operation
        Collections.reverse(res);
        return res;
    }


    //--------------------- Solution 4 ----------------------//
    // Morris traversal
    // Reverse of preorder traversal of mirrored original tree
    public List<Integer> postorderTraversal4(TreeNode root) {
        List<Integer> res = new ArrayList();
        TreeNode cur = root;
        while (cur != null) {
            TreeNode pre = cur.right;
            if (pre != null) {
                // find predecessor
                while (pre.left != null && pre.left != cur) {
                    pre = pre.left;
                }
                // case 1: haven't visited right subtree
                if (pre.left == null) {
                    res.add(cur.val); // visit
                    pre.left = cur;
                    cur = cur.right;
                }
                // case 2: returned from right subtree
               if (pre.left == cur) {
                    pre.left = null;
                    cur = cur.left;
                }
            } else {
                res.add(cur.val);
                cur = cur.left;
            }
        }
        Collections.reverse(res);
        return res;
    }
}
