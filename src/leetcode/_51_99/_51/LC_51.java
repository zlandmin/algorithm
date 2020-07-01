package leetcode._51_99._51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
51. N-Queens
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class LC_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        initBoard(board);
        helper(res, board, 0);
        return res;
    }

    private void initBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
    }

    private List<String> generate(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (char c : row) {
                sb.append(c);
            }
            list.add(sb.toString());
        }
        return list;
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

    private void helper(List<List<String>> res, char[][] board, int rowIndex) {
        if (rowIndex == board.length) {
            res.add(generate(board));
            return;
        }

        for (int colIndex = 0; colIndex < board.length; colIndex++) {
            if (isValid(board, rowIndex, colIndex)) {
                board[rowIndex][colIndex] = 'Q';
                helper(res, board, rowIndex + 1);
                board[rowIndex][colIndex] = '.';
            }
        }
    }
}
