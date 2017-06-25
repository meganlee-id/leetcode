package com.meganlee;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class BinaryTreeMaxDepth {
	//-------------------  Solution 1 --------------------------//
    // Use classic recursion
    public int maxDepth(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // general case
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
    
	//-------------------  Solution 2 --------------------------//
    // Level-by-level traversal (BFS)
    public int maxDepth2(TreeNode root) {
        // input validation
        if (root == null) {
            return 0;
        }
        // first level, only hold non-null TreeNodes
        List<TreeNode> level = Arrays.asList(root);
        int max = 0;
        while (!level.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for (TreeNode node: level) {
                // add next level non-null nodes
                if (node.left != null)  {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            level = nextLevel;
            max++;
        }
        return max;
    }
}

