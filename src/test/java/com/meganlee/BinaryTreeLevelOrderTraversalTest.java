package com.meganlee;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeLevelOrderTraversalTest {
	BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
	
    String[] s1 = {"1", "2", "3", "#", "#", "4", "#", "#", "5"};
    String[] s2 = {"3", "9", "20", "#", "#", "15", "7"};
    TreeNode root1 = TreeNode.buildTreeFromLevelOrder(s1);
    TreeNode root2 = TreeNode.buildTreeFromLevelOrder(s2);

	private String calculate(TreeNode root) {
		return solution.levelOrder(root).toString();
	}

	@Test
	public void test1() {
		System.out.println(calculate(root1));
		Assert.assertEquals("[[1], [2, 3], [4], [5]]", calculate(root1));
	}

	@Test
	public void test2() {
		Assert.assertEquals("[[3], [9, 20], [15, 7]]", calculate(root2));
	}
}