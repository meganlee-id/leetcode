package com.meganlee;

public class RecoverBinarySearchTree {
    TreeNode[] pair = new TreeNode[2];
    TreeNode pre = null; // optionally: TreeNode[] pre = new TreeNode[1]; 

    public void recoverTree(TreeNode root) {
        findPair(root);  
        swapPair();
    }
    
    private void findPair(TreeNode cur) {
        // base case
        if (cur == null) {
            return;
        }
        // general case: inorder traverse
        findPair(cur.left);
        if (pre != null && pre.val > cur.val) { // mispositioned node
            pair[0] = (pair[0] == null) ? pre : pair[0];
            pair[1] = (pair[0] != null) ? cur : pair[1];
        }
        pre = cur;
        findPair(cur.right);
    }

    private void swapPair() {
        int temp = pair[0].val;
        pair[0].val = pair[1].val;
        pair[1].val = temp;
    }
}
