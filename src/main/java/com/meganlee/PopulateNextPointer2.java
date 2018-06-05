package com.meganlee;


public class PopulateNextPointer2 {
    //------------------- Solution  ----------------//
    // Same as PopulateNextPointer1 solution3
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelHead = root;
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode pre = dummyHead;
        while (levelHead != null) {
            // 1. link this level
            TreeLinkNode cur = levelHead;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            // 2. update head for level
            levelHead = dummyHead.next;
            dummyHead.next = null;
            pre = dummyHead;
        }
    }
}