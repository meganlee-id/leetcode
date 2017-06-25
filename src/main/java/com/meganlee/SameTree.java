package com.meganlee;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    //----------------  Solution 1 --------------------//
    // classic recursion
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case: deal with nulls
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        // general case: both non-null
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    

    //----------------  Solution 2 --------------------//
    // BFS: level-by-level with "#" indicating a null node
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> levelP = new LinkedList<TreeNode>(Arrays.asList(p));
        Queue<TreeNode> levelQ = new LinkedList<TreeNode>(Arrays.asList(q));
        while (levelP.size() == levelQ.size() && !levelP.isEmpty()) {
            // pull one node
            TreeNode pNode = levelP.poll();
            TreeNode qNode = levelQ.poll();
            // compare
            String pNodeStr = (pNode == null) ? "#" : String.valueOf(pNode.val);
            String qNodeStr = (qNode == null) ? "#" : String.valueOf(qNode.val);
            if (!pNodeStr.equals(qNodeStr)) {
                return false;
            }
            // add next level
            if (pNode != null) {
                levelP.offer(pNode.left);
                levelP.offer(pNode.right);
            }
            if (qNode != null) {
                levelQ.offer(qNode.left);
                levelQ.offer(qNode.right);
            }
        }
        return levelP.isEmpty() && levelQ.isEmpty();
    }

}

// NOTE : Alternatively: we could compute in-order and pre-order to compare
