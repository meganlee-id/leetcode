package com.meganlee;


public class RotateImage {
    //------------------ Solution 1 ----------------------//
    // classic 4 bounds
    public void rotate(int[][] matrix) {
        // check if the matrix is a NXN matrix
        // check null pointer or empty array
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        // rotate layer by layer
        int N = matrix.length;
        int lo = 0, hi = N - 1;
        while(lo < hi) { // when lo == hi, no rotation needed.
            for (int offset = 0; offset < hi - lo; offset++) {
                int temp = matrix[lo][lo + offset];
                matrix[lo][lo + offset] = matrix[hi - offset][lo];
                matrix[hi - offset][lo] = matrix[hi][hi - offset];
                matrix[hi][hi - offset] = matrix[lo + offset][hi];
                matrix[lo + offset][hi] = temp;
            }
            lo++;
            hi--;
        }
    }

    //------------------ Solution 2 ----------------------//
    // flip twice
    public void rotate2(int[][] matrix) {
        // check if the matrix is a NXN matrix
        // check null pointer or empty array
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        // step 1: first flip horizontally
        int N = matrix.length;
        for (int i = 0; i < N / 2; i++) { // only flip N/2 grid
            for (int j = 0; j < N; j++) {
                swap(matrix, i, j, N - 1 - i, j);
            }
        }
        // step 2: flip diagonally
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    //------------------ Solution 3 ----------------------//
    // find the transition function
    // (i, j) --> (j, len - 1 - i)
    // this is naive, used extra space ---> another matrix
    public void rotate3(int[][] matrix) {
        // check if the matrix is a NXN matrix
        // check null pointer or empty array
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        // put to new matrix
        int N = matrix.length;
        int[][] newMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newMatrix[j][N - 1 - i] = matrix[i][j];
            }
        }
        // copy back
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
        // matrix = newMatrix; won't work, since "matrix" is a local variable
        // if return type changed to int[][], we could return newMatrix
    }
}