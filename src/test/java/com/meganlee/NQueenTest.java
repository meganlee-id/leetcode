package com.meganlee;

import java.util.*;
import org.junit.*;

public class NQueenTest {
    NQueen solution = new NQueen();
    private String calculate(int n) {
        List<List<String>> res = solution.solveNQueens2(n);
        System.out.println("n=" + n);
        int count = 1;
        for (List<String> solution: res) {
            System.out.println("========== Solution " + count + " ==========");
            for (String row: solution) {
                System.out.println(row);
            }
            count++;
        }
        Collections.sort(res, (l1, l2) -> l1.toString().compareTo(l2.toString()));
        return res.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals(
            "[[..Q., Q..., ...Q, .Q..], [.Q.., ...Q, Q..., ..Q.]]",
            calculate(4)
        );
    }
}
