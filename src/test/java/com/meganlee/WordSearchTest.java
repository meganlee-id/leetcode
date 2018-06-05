package com.meganlee;

import java.util.*;
import org.junit.*;

public class WordSearchTest {
    WordSearch solution = new WordSearch();
    private boolean calculate(char[][] board, String word) {
        return solution.exist(board, word);
    }

    char[][] board1 = {
        "bb".toCharArray(), 
        "ab".toCharArray(), 
        "ba".toCharArray()
    };


    char[][] board2 = {
      {'A','B','C','E'},
      {'S','F','C','S'},
      {'A','D','E','E'}
    };

    @Test
    public void test1() {
        Assert.assertEquals(
            true,
            calculate(board1, "babbba")
        );
    }

    @Test
    public void test2() {
        Assert.assertEquals(
            true,
            calculate(board2, "ABCCED")
        );

        Assert.assertEquals(
            false,
            calculate(board2, "SEE")
        );

        Assert.assertEquals(
            false,
            calculate(board2, "ABCB")
        );
    }
}
