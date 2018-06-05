package com.meganlee;

import java.util.*;

public class NQueen {
    //--------------- Solution 1 --------------------//
    // use a board as a solution builder
    public List<List<String>> solveNQueens(int n) {
        // input checking
        if (n <= 0) {
            return new ArrayList();
        }
        // use a 2D array as solution builder
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        List<List<String>> res = new ArrayList();
        helper(res, board, 0);
        return res;
    }

    private void helper(List<List<String>> res, char[][] board, int row) {
        // base case
        if (row == board.length) {
            res.add(toResult(board));
            return;
        }
        // general case
        for (int col = 0; col < board.length; col++) {
            board[row][col] = 'Q';
            if (valid(board, row, col)) {
                helper(res, board, row + 1);
            }
            board[row][col] = '.';
        }
    }

    private List<String> toResult(char[][] board) {
        List<String> solution = new ArrayList();
        for (int row = 0; row < board.length; row++) {
            solution.add(String.valueOf(board[row]));
        }
        return solution;
    }

    private boolean valid(char[][] board, int row, int col) {
        for (int offset = 1; offset <= row; offset++) {
            if (board[row - offset][col] == 'Q') { // straight-up
                return false;
            }
            if (col - offset >= 0 && board[row - offset][col - offset] == 'Q') { // left-up
                return false;
            }
            if (col + offset < board.length && board[row - offset][col + offset] == 'Q') { // right-upp
                return false;
            }
        }
        return true;
    }


    //--------------- Solution 2 --------------------//
    // interpreter this as a permutation problem
    // perm={1, 2, 4, 5, 3} -- index: row -- perm[index]: col
    // Time Limit Exceeded
    public List<List<String>> solveNQueens2(int n) {
        // input checking
        if (n <= 0) {
            return new ArrayList();
        }
        // use a 1D-array to indicate solution
        List<List<String>> res = new ArrayList();
        helper(res, new ArrayList(), n, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<Integer> item, int n, int row) {
        // base case
        if (row == n) {
            res.add(toResult(item, n));
            return;
        }
        // general case
        for (int i = 0; i < n; i++) {
            item.add(i);
            if (valid(item)) {
                helper(res, item, n, row + 1);
            }
            item.remove(item.size() - 1);
        }
    }

    private List<String> toResult(List<Integer> item, int n) {
        List<String> solution = new ArrayList();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[item.get(i)] = 'Q';
            solution.add(String.valueOf(row));
        }
        return solution;
    }

    private boolean valid(List<Integer> item) {
        // compare last index with the previous ones
        int row = item.size() - 1;
        for (int preRow = 0; preRow < row; preRow++) {
            int col = item.get(row), preCol = item.get(preRow);
            if (col == preCol || Math.abs(col - preCol) == Math.abs(row - preRow)) {
                return false;
            }
        }
        return true;
    }
}
