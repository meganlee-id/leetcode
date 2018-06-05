package com.meganlee;

import java.util.*;

public class ConvertSortedListToBST {
    //------------------- Solution 1 --------------------//
    // List --> Array, then Preorder recursion
    // S=O(N), T=O(N) Time Limit Exceeded
    public TreeNode sortedListToBST(ListNode head) {
        // input checking
        if (head == null) {
            return null;
        }
        // first convert the List into an Array
        List<Integer> vals = new ArrayList();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        return helper(vals, 0, vals.size() - 1);
    }

    private TreeNode helper(List<Integer> vals, int start, int end) {
        // base case
        if (start > end) {
            return null;
        }
        // general case
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(vals.get(mid));
        node.left = helper(vals, start, mid - 1);
        node.right = helper(vals, mid + 1, end);
        return node;
    }

    //------------------- Solution 2 --------------------//
    // Inorder Recursion: O(1) Space, O(n) Time
    private ListNode cur; // *** ATTENTION: points to the next val to be converted
    public TreeNode sortedListToBST2(ListNode head) {
        // input checking
        if (head == null) {
            return null;
        }  
        cur = head; // initialize cur 
            
        // get the size of the List
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return buildBST(size); // cur must either be a instance variable or a ListNode[1]
    }

    private TreeNode buildBST(int size) {
        // Base case
        if (size == 0) {
            return null;
        }
        // General case
        // step 1: traverse/build left
        TreeNode left = buildBST(size / 2);
        // step 2: traverse/build root
        TreeNode node = new TreeNode(cur.val); // order is important! has to be placed here
        node.left = left;
        cur = cur.next;
        // step 3: traverse/build right
        node.right = buildBST(size - size / 2 - 1);
        return node;
    }
}

