package com.meganlee;

import java.util.*;

public class FlattenBinaryTree {
    //--------------- Solution 1 ---------------//
    // Pre-Order recursion: Head to tail
    private TreeNode newTail = new TreeNode(0);
    public void flatten(TreeNode root) {
        // Base Case
        if (root == null) {
            return;
        }
        // General Case
        // save subtrees
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 1. visit root && update newTail
        newTail.left = null;
        newTail.right = root;
        newTail = newTail.right;
        // 2. left
        flatten(left);
        // 3. right
        flatten(right);
    }

    //--------------- Solution 2 ---------------//
    // Post-Order-Mirror recursion: Tail to head
    private TreeNode newHead = null;
    public void flatten2(TreeNode root) {
        // Base Case
        if (root == null) {
            return;
        }
        // General Case
        // 1.right
        flatten2(root.right); 
        // 2.left
        flatten2(root.left);
        // 3. visit root
        root.left = null;
        root.right = newHead;
        newHead = root; // update newHead
    }

    //--------------- Solution 3 ---------------//
    // Iterative Pre-Order cur+stack
    public void flatten3(TreeNode root) {
        TreeNode newTail = new TreeNode(0);
        Stack<TreeNode> s = new Stack();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {  //--- GOING DOWN ---
                s.push(cur.right);      // original: push(cur)
                // VISIT cur
                newTail.left = null;
                newTail.right = cur;
                // update newTail
                newTail = cur;
                cur = cur.left;         // left
            } else {            //--- GOING UP   ---
                cur = s.pop();          //  original: cur = s.pop(); cur = cur.right
             }
        }
    }
}

