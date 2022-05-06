package com.meganlee;

import java.util.*;

class SubtreeOfAnotherTree {
    //--------------- Solution 1 -----------------//
    // recursion
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    
    public boolean traverse(TreeNode s,TreeNode t) {
        // s and t might be null
        return isSameTree(s,t) || (s != null && (traverse(s.left,t) || traverse(s.right,t)));
    }
    
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

    //--------------- Solution 2 -----------------//
    // recursive serialization
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        StringBuilder sBuilder = new StringBuilder();
        StringBuilder tBuilder = new StringBuilder();
        serialize(s, sBuilder);
        serialize(t, tBuilder);
        // Java uses a naive "contains" algorithm so to ensure linear time, 
        // replace with KMP algorith
        return sBuilder.toString().contains(tBuilder.toString());
    }

    private void serialize(TreeNode cur, StringBuilder res) {
        // base case null
        if (cur == null) {
            res.append("#"); 
            return;
        }
        // general case, not null node
        res.append("|" + cur.val + "|");
        serialize(cur.left, res);
        serialize(cur.right, res);
    }
}