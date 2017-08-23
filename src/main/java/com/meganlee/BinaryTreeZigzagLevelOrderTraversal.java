package com.meganlee;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    //------------------- Solution 1 -------------------//
    // BFS: level + nextLevel
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // input validation
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        // define the first level
        List<TreeNode> level = Arrays.asList(root);
        int curLevel = 0; //------ see which level it is
        // level by level traversal
        while (!level.isEmpty()) {
            List<Integer> vals = new ArrayList();
            List<TreeNode> nextLevel = new ArrayList();
            for (TreeNode n : level) {
                vals.add(n.val);
                if (n.left != null) {
                    nextLevel.add(n.left);
                }
                if (n.right != null) {
                    nextLevel.add(n.right);
                }
            }
            if (curLevel % 2 == 1) {
                Collections.reverse(vals);
            }
            curLevel++;
            res.add(vals);
            level = nextLevel;
        }
        return res;
    }
}
