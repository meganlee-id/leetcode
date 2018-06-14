package com.meganlee;

import java.util.*;

public class SurroundedRegions {
    //----------------- Solution 1 --------------------//
    // DFS iterative
    public void solve(char[][] board) {
        // input checking
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        // initialize: find all 'O' on the boundary and put them in the queue
        Queue<Integer>  queue = new LinkedList();
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            enqueue(queue, board, i, 0);
            enqueue(queue, board, i, cols - 1);
        }
        for (int j = 1; j < cols - 1; j++) {
            enqueue(queue, board, 0, j);
            enqueue(queue, board, rows - 1, j);
        }

        // start from the boundary marked as 'O' and bfs and mark all connected 'O' to be '#'
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / cols, y = cur % cols;
            // mark it '#' also mean it's VISITED!
            // if we don't want to change it. just use a parallel board as visited 
            board[x][y] = '#'; 
            enqueue(queue, board, x - 1, y);
            enqueue(queue, board, x + 1, y);
            enqueue(queue, board, x, y - 1);
            enqueue(queue, board, x, y + 1);
        }

        // change all rest 'O' -> 'X', change '#' -> 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    // only position of char 'O' is put in queue
    public static void enqueue(Queue<Integer> queue, char[][] board, int x, int y) {
        int rows = board.length, cols = board[0].length;
        if (0 <= x && x < rows && 0 <= y && y < cols && board[x][y] == 'O'){
            queue.offer(x * cols + y);  // a unique way of restoring x & y
        }
    }


    //----------------- Solution 1 --------------------//
    // DFS recursive
    private static char BORDER = '*';
    public void solve2(char[][] board) {
        if (board == null) return;
        int m = board.length;
        int n = m != 0 ? board[0].length : 0;
        for (int i = 0 ; i < m ; i++) {
            markBorderConnected(board, i, 0);
            if (n-1 > 0) markBorderConnected(board, i, n-1);
        }
        for (int i = 0 ; i < n ; i++) {
            markBorderConnected(board,0, i);
            if (m-1 > 0) markBorderConnected(board,m-1, i);
        }
        for (int i = 0 ; i < m ;i++) {
            for (int j = 0 ; j < n ;j++)
                board[i][j] = board[i][j] == 'O' ? 'X': board[i][j];
        }
        for (int i = 0 ; i < m ;i++) {
            for (int j = 0 ; j < n ;j++)
                board[i][j] = board[i][j] == BORDER ? 'O': board[i][j];
        }
    }
        
    void markBorderConnected(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            int m = board.length;
            int n = board[0].length;
            board[i][j] = BORDER;
            if (i-1 > 0 && board[i-1][j] == 'O') markBorderConnected(board, i-1, j);
            if (j+1 < n && board[i][j+1] == 'O') markBorderConnected(board, i, j+1);
            if (i+1 < m && board[i+1][j] == 'O') markBorderConnected(board, i+1, j);
            if (j-1 > 0 && board[i][j-1] == 'O') markBorderConnected(board, i, j-1);
        }        
    }
}