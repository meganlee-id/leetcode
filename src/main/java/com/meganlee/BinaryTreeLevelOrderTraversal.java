package com.meganlee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    //------------------- Solution 1 -------------------//
    // BFS: level + nextLevel (most recommended)
    public List<List<Integer>> levelOrder(TreeNode root) {
        // input validation
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // define the first level
        List<TreeNode> level = Arrays.asList(root);
        // level by level traversal
        while (!level.isEmpty()) { // also valid: level.size() != 0
            List<Integer> vals = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode n: level) {
                vals.add(n.val);
                if (n.left != null) {
                    nextLevel.add(n.left);
                }
                if (n.right != null) {
                    nextLevel.add(n.right);
                }
            }
            res.add(vals);
            level = nextLevel;
        }
        
        return res;
    }


    //------------------- Solution 2 -------------------//
    // BFS: size + queue  (ok for most time)
    public List<List<Integer>> levelOrder2(TreeNode root) {
        // input validation
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        // traverse level by level
        Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));
        while (!q.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                vals.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(vals);
        }
        return res;
    }
}
