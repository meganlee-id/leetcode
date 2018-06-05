package com.meganlee;

import java.util.*;
import org.junit.*;

public class SudokuSolverTest {
    SudokuSolver solution = new SudokuSolver();
    private String calculate(char[][] board) {
        printBoard(board, "==== input =====");
        solution.solveSudoku(board);
        printBoard(board, "==== solution =====");
        return strBoard(board);
    }

    private  void printBoard(char[][] board, String msg) {
        System.out.println(msg);
        int N = board.length;
        for (int i = 0; i < N*N; i++) {
            System.out.print(board[i/N][i%N]);
            if (i%N == N-1) System.out.print('\n');
        }
    }

    private String strBoard(char[][] board) {
        int N = board.length;
        StringBuilder sb = new StringBuilder();
        for (char[] row: board) {
            sb.append(row);
        }
        return sb.toString();
    }

    char[][] board = {
        "..9748...".toCharArray(),
        "7........".toCharArray(),
        ".2.1.9...".toCharArray(),
        "..7...24.".toCharArray(),
        ".64.1.59.".toCharArray(),
        ".98...3..".toCharArray(),
        "...8.3.2.".toCharArray(),
        "........6".toCharArray(),
        "...2759..".toCharArray()
    };

    @Test
    public void test() {
        Assert.assertEquals(
            "519748632783652419426139875357986241264317598198524367975863124832491756641275983",
            calculate(board)
        );
    }
}
