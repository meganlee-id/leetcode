package com.meganlee;

import java.util.*;

public class BinaryTreeMinDepth {
    //-------------------  Solution 1 --------------------------//
    // Use classic recursion
    public int minDepth(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        // general case
        int left  = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? 
                Math.max(left, right) + 1 : 
                Math.min(left, right) + 1;
    }
    

    //-------------------  Solution 2 --------------------------//
    // Level-by-level traversal (BFS)
    public int minDepth2(TreeNode root) {
        // input validation
        if (root == null) {
            return 0;
        }
        // first level, only hold non-null TreeNodes
        List<TreeNode> level = Arrays.asList(root);
        int min = 0;
        while (!level.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList();
            for (TreeNode node: level) {
                // first leaf encountered, return
                if (node.left == null && node.right == null) {
                    return min + 1;
                }
                // add next level non-null nodes
                if (node.left != null)  {
                    nextLevel.add(node.left);
                }
                if (node.right != null){
                    nextLevel.add(node.right);
                }
            }
            level = nextLevel;
            min++; 
        }
        return min;
    }
}