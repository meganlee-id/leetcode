package com.meganlee;

import java.util.*;
import org.junit.*;

public class UniquePathTest {
    UniquePath solution = new UniquePath();
    private int calculate(int m, int n) {
        return solution.uniquePaths5(m, n);
    }

    int[] mArray   = {0, 1, 12, 23};
    int[] nArray   = {0, 0, 8,  12};
    int[] expected = {0, 0, 31824, 193536720};

    @Test
    public void test() {
        for (int i = 0; i < mArray.length; i++) {
            Assert.assertEquals(expected[i], calculate(mArray[i], nArray[i]));
        }
    }
}