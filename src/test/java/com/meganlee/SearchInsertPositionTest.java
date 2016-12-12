package com.meganlee;

import org.junit.Assert;
import org.junit.Test;

public class SearchInsertPositionTest {
	SearchInsertPosition solution = new SearchInsertPosition();
	int[] A = {1, 3, 4, 5, 8};
	private int calculate(int[] A, int target) {
		return solution.searchInsert(A, target);
	}

	@Test
	public void testExistingElem() {
		Assert.assertEquals(2, calculate(A, 4));
	}

	@Test
	public void testNonExistingElem() {
		Assert.assertEquals(0, calculate(A, 0));
	}
}