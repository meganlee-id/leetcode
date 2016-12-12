package com.meganlee;

import org.junit.Assert;
import org.junit.Test;

public class SearchForARangeTest {
	SearchForARange solution = new SearchForARange();
	private int[] calculate(int[] A, int target) {
		return solution.searchRange(A, target);
	}

	int[] A = {2, 3, 4, 8, 8, 9};
	int[] defaultResult = {-1, -1};

	@Test
	public void testAllSmallerThanTarget() {
		Assert.assertArrayEquals(defaultResult, calculate(A, 10));
	}

	@Test
	public void testAllLargerThanTarget() {
		Assert.assertArrayEquals(defaultResult, calculate(A, 1));
	}

	@Test
	public void testTargetInBetween() {
		Assert.assertArrayEquals(defaultResult, calculate(A, 6));
	}

	@Test
	public void testSingleExistence() {
		Assert.assertArrayEquals(new int[]{1, 1}, calculate(A, 3));
	}

	@Test
	public void testMultipleExistence() {
		Assert.assertArrayEquals(new int[]{3, 4}, calculate(A, 8));
	}
}