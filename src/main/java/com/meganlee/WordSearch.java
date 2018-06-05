package com.meganlee;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int M = board.length, N = board[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // for each cell, do a dfs search
                if (helper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // board start: (i,j)
    // word  start: index cur
    private boolean helper(char[][] board, int i, int j, String word, int cur) {
        // base case
        if (cur == word.length()) { // no more char in word, match
            return true;
        }
        // cur char NOT match ----- validate parameter
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(cur)) {
            return false;
        }
        // cur char match --------- travel 4 directions
        board[i][j] = '#'; // '#' means visited
        if (helper(board, i - 1, j, word, cur + 1) || helper(board, i + 1, j, word, cur + 1) ||
            helper(board, i, j - 1, word, cur + 1) || helper(board, i, j + 1, word, cur + 1)
        ) {
            return true;
        }
        board[i][j] = word.charAt(cur); // recover '#'
        return false;
    }
}
