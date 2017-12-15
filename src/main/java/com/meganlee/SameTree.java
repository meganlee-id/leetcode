package com.meganlee;

import java.util.*;

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
            // compare
            String pNodeStr = (pNode == null) ? "#" : String.valueOf(pNode.val);
            String qNodeStr = (qNode == null) ? "#" : String.valueOf(qNode.val);
            // if anything differs, will return here
            if (!pNodeStr.equals(qNodeStr)) {
                return false;
            }
            // add to next level: here we're guaranteed that this level is same
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

// NOTE : Alternatively: we could compute a pair of (in-order string,  and pre/post/level-order string) to compare
