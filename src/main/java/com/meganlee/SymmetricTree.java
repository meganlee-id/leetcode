package com.meganlee;

import java.util.*;

public class SymmetricTree {
    //----------------  Solution 1 --------------------//
    // classic recursion
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return mirrorTree(root.left, root.right);
    }
    
    private boolean mirrorTree(TreeNode n1, TreeNode n2) {
        // base case: deal with nulls
        if (n1 == null && n2 == null) { // both null
            return true;
        }
        if (n1 == null || n2 == null) { // only one null
            return false;
        }
        // general case: both non-null
        return n1.val == n2.val && mirrorTree(n1.left, n2.right) && mirrorTree(n1.right, n2.left);
    }

    //-------------------- Solution 2 -----------------------//
    // BFS: level-by-level with "#" indicating a null node
    public boolean isSymmetric2(TreeNode root) {
        // input validation
        if (root == null) {
            return true;
        }
        Queue<TreeNode> left  = new LinkedList(Arrays.asList(root.left));
        Queue<TreeNode> right = new LinkedList(Arrays.asList(root.right));
        while (!left.isEmpty()) {
            // pull one node
            TreeNode l = left.poll();
            TreeNode r = right.poll();
            // get str representation
            String lval = (l == null) ? "#" : String.valueOf(l.val);
            String rval = (r == null) ? "#" : String.valueOf(r.val);
            // compare
            if (!lval.equals(rval)) {
                return false;
            }
            // add next level
            if (l != null) {
                left.offer(l.left);
                left.offer(l.right);
                right.offer(r.right);  // attention: add right first and then left
                right.offer(r.left);
            }
        }
        return true;
    }
}

