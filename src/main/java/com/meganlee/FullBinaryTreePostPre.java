package com.meganlee;

// http://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

public class FullBinaryTreePostPre { 
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
        }
    }
    
    // [pr1, pr2], [po1, po2] both index includsive
    static Node constructTreeUtil(int pre[], int pr1, int pr2, int post[], int po1, int po2) {   
        // base case
        if (pr1 > pr2) {
            return null;
        }

        // general case
        Node root = new Node(pre[pr1]);
        if (pr1 == pr2) {   // no children
            return root;
        } else {            // full binary means both subtree exist (pre.lenth >= 3)
            int leftVal  = pre[pr1 + 1];
            int rightVal = post[po2 - 1];
            // assume no duplicate values in pre[]
            int leftIdxInPost = Arrays.stream(post).boxed().collect(Collectors.toList()).indexOf(leftVal);
            int rightIdxInPre = Arrays.stream(pre).boxed().collect(Collectors.toList()).indexOf(rightVal);
            // int leftIdxInPost = indexOf(post, leftVal); // use a util fuction indexOf()
            // int rightIdxInPre = indexOf(pre, rightVal); // use a util fuction indexOf()

            root.left = constructTreeUtil(pre, pr1 + 1, rightIdxInPre - 1, post, po1, leftIdxInPost);
            root.right = constructTreeUtil(pre, rightIdxInPre, pr2, post, leftIdxInPost + 1, po2 - 1);
            return root;
        }
    }
 
    static int indexOf(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
 
    static void printInorder(Node root, StringBuilder sb) {
        if (root == null) {
            sb.append("");
        } else {
            printInorder(root.left, sb);
            sb.append(root.data + " ");
            printInorder(root.right, sb);
        }
    }
}
