package com.meganlee;

import java.util.*;

public class FlattenBinaryTree {
    //--------------- Solution 1 ---------------//
    // Pre-Order recursion: Head to tail
    private TreeNode newTail = null;
    public void flatten(TreeNode root) {
        // Base Case
        if (root == null) {
            return;
        }
        // General Case
        // save subtrees
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 1. visit root
        if (newTail != null) { // connect tail to cur
            newTail.left = null;
            newTail.right = root;
        }
        newTail = root; // update newTail
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
        TreeNode newTail = null;
        Stack<TreeNode> s = new Stack();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {  //--- GOING DOWN ---
                s.push(cur.right);      // original: push(cur)
                if (newTail != null) {  // VISIT cur
                    newTail.left = null;
                    newTail.right = cur;
                }
                newTail = cur;          // update newTail
                cur = cur.left;         // left
            } else {            //--- GOING UP   ---
                cur = s.pop();          //  original: cur = s.pop(); cur = cur.right
             }
        }
    }
}

