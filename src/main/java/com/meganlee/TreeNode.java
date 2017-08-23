package com.meganlee;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    // TreeNode Definition
    int val;
    TreeNode left, right;
    public TreeNode(int x) {
        val = x;
    }

    // Build Tree From Level Order String[] with # as null
    public static TreeNode buildTreeFromLevelOrder(String[] s) {
        // input validation
        if (s == null || s.length == 0) {
            return null;
        }
        // assume String[] s is valid: only contains int or '#'
        TreeNode root = new TreeNode(Integer.valueOf(s[0]));
        Queue<TreeNode> q = new LinkedList(Arrays.asList(root)); // use a QUEUE
        for (int i = 1; i < s.length - 1; i += 2) { // starting from index 1, take 2 nodes each loop
            TreeNode node = q.poll();
            String left = s[i];
            String right = s[i + 1];
            if (!left.equals("#")) {
                node.left = new TreeNode(Integer.valueOf(left));
                q.offer(node.left);
            }
            if (!right.equals("#")) {
                node.right = new TreeNode(Integer.valueOf(right));
                q.offer(node.right);
            }
        }
        return root;
    }
}