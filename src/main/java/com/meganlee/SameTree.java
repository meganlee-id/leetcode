package com.meganlee;

import java.util.*;

public class SameTree {
    //----------------  Solution 1 --------------------//
    // classic recursion
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case: deal with nulls
        if (p == null && q == null) { // both null
            return true;
        }
        if (p == null || q == null) { // only one null
            return false;
        }
        // general case: both non-null
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    

    //----------------  Solution 2 --------------------//
    // BFS:  level-by-level traversal including null node
    //       during compare, using a "#" as a null string value
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> levelP = new LinkedList(Arrays.asList(p)); // fine if p is null
        Queue<TreeNode> levelQ = new LinkedList(Arrays.asList(q)); // fine if q is null
        while (!levelP.isEmpty()) { // levelP and levelQ are always having the same size
            // pull one node from head of queue
            TreeNode pNode = levelP.poll();
            TreeNode qNode = levelQ.poll();
            // get str representation
            String pNodeStr = (pNode == null) ? "#" : String.valueOf(pNode.val);
            String qNodeStr = (qNode == null) ? "#" : String.valueOf(qNode.val);
            // compare
            if (!pNodeStr.equals(qNodeStr)) {
                return false;
            }
            // add to next level
            if (pNode != null) {
                levelP.offer(pNode.left);
                levelP.offer(pNode.right);
                levelQ.offer(qNode.left);
                levelQ.offer(qNode.right);
            }
        }
        return true;
    }
}
