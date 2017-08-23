package com.meganlee;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	//----------------  Solution 1 --------------------//
    // classic recursion
    public boolean isSymmetric(TreeNode root) {
        if (root  == null) {
            return true;
        }
        return mirrorTree(root.left, root.right);
    }
    
    private boolean mirrorTree(TreeNode n1, TreeNode n2) {
        // base case: deal with nulls
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        // general case: both non-null
        if (n1.val != n2.val) {
            return false;
        }
        return mirrorTree(n1.left, n2.right) && mirrorTree(n1.right, n2.left);
    }

    //-------------------- Solution 2 -----------------------//
    // BFS: level-by-level with "#" indicating a null node
    public boolean isSymmetric2(TreeNode root) {
        // input validation
        if (root == null) {
            return true;
        }

        Queue<TreeNode> left = new LinkedList(Arrays.asList(root.left));
        Queue<TreeNode> right = new LinkedList(Arrays.asList(root.right));
        while (left.size() == right.size() && !left.isEmpty()) {
            // pull one node
            TreeNode l = left.poll();
            TreeNode r = right.poll();
            // compare
            String lval = (l == null) ? "#" : String.valueOf(l.val);
            String rval = (r == null) ? "#" : String.valueOf(r.val);
            if (!lval.equals(rval)) {
                return false;
            }
            // add next level
            if (l != null) {
                left.offer(l.left);
                left.offer(l.right);
            }
            if (r != null) {
                right.offer(r.right);  // attention: add right first and then left
                right.offer(r.left);
            }
        }
        return left.isEmpty() && right.isEmpty();
    }
}

