package leetcode._1_100._52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
52. N-Queens II
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class LC_52 {
    public int res = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        initBoard(board);
        helper(board, 0);
        return res;
    }

    private void initBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
    }

    private boolean isValid(char[][] board, int rowIndex, int colIndex) {
        for (int i = 0; i < rowIndex; i++) {
            if (board[i][colIndex] == 'Q') {
                return false;
            }
        }

        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void helper(char[][] board, int rowIndex) {
        if (rowIndex == board.length) {
            res++;
            return;
        }

        for (int colIndex = 0; colIndex < board.length; colIndex++) {
            if (isValid(board, rowIndex, colIndex)) {
                board[rowIndex][colIndex] = 'Q';
                helper(board, rowIndex + 1);
                board[rowIndex][colIndex] = '.';
            }
        }
    }
}
