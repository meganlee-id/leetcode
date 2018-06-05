package com.meganlee;

public class ConvertSortedArrayToBST {
    //--------------------- Solution 1 ------------------------//
    // Preorder Recursion
    public TreeNode sortedArrayToBST(int[] num) {
        // input checking
        if (num == null || num.length == 0) {
            return null;
        }
        return buildBST(num, 0, num.length - 1);
    }

    private TreeNode buildBST(int[] num, int start, int end) {
        // base case
        if (start > end) {
            return null;
        }
        // general case
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = buildBST(num, start, mid - 1);
        node.right = buildBST(num, mid + 1, end);
        return node;
    }

    //--------------------- Solution 2 ------------------------//
    // Inorder Recursion
    private int cur; // *** ATTENTION: points to the next val to be converted
    public TreeNode sortedArrayToBST2(int[] num) {
        // input checking
        if (num == null || num.length == 0) {
            return null;
        }
        return buildBST(num, num.length);
    }

    private TreeNode buildBST(int[] num, int size) {
        // Base Case
        if (size == 0) {
            return null;
        }
        // General Case
        // step 1: traverse/build left
        TreeNode left = buildBST(num, size / 2);
        // step 2: traverse/build root
        TreeNode node = new TreeNode(num[cur]);  // order is important! has to be placed here
        node.left = left;
        cur++;
        // step 3: traverse/build right
        node.right = buildBST(num, size - size / 2 - 1);
        return node;
    }
}

