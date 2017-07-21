package com.meganlee;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

public class ConstructPreorderInorder {
    //--------------- Solution 1  ----------------//
    // Lookup table: HashMap
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // input validation: (assume that preorder and inorder are valid)
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        // construct a fast querying data structure for inorder!!
        int N = inorder.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, N - 1, preorder, 0, N - 1, map);
    }

    // p1,p2 inclusive
    private TreeNode helper(int[] inorder, int i1, int i2, int[] preorder, int p1, int p2, Map<Integer, Integer> map) {
        // base case
        if (i1 > i2) {
            return null;
        }
        // general case
        int rootVal = preorder[p1];
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left  = helper(inorder, i1, rootIdx - 1, preorder, p1 + 1, p1 + rootIdx - i1, map);
        root.right = helper(inorder, rootIdx + 1, i2, preorder, p1 + rootIdx - i1 + 1, p2, map);
        return root;
    }

    //--------------- Solution 2  ----------------//
    // Lookup table: scan List.indexOf()
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        List<Integer> lookup = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        int N = inorder.length;
        return helper(inorder, 0, N - 1, preorder, 0, N - 1, lookup);
    }

    private TreeNode helper(int[] inorder, int i1, int i2, int[] preorder, int p1, int p2, List<Integer> lookup) {
        if (i1 > i2) {
            return null;
        }
        int rootVal = preorder[p1];
        int rootIdx = lookup.indexOf(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left  = helper(inorder, i1, rootIdx - 1, preorder, p1 + 1, p1 + rootIdx - i1, lookup);
        root.right = helper(inorder, rootIdx + 1, i2, preorder, p1 + rootIdx - i1 + 1, p2, lookup);
        return root;
    }
}