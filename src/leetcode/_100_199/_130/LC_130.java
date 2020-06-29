package leetcode._100_199._130;

/*
130. Surrounded Regions
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class LC_130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                helper(board, i, 0, visited, false);
            }
            if (board[i][n - 1] == 'O') {
                helper(board, i, n - 1, visited, false);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                helper(board, 0, j, visited, false);
            }
            if (board[m - 1][j] == 'O') {
                helper(board, m - 1, j, visited, false);
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    helper(board, i, j, visited, true);
                }
            }
        }
    }

    private void helper(char[][] board, int row, int col, boolean[][] visited, boolean flip) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) {
            return;
        }

        if (visited[row][col]) {
            return;
        }

        if (board[row][col] == 'X') {
            return;
        }

        if (flip) {
            board[row][col] = 'X';
        }

        visited[row][col] = true;
        helper(board, row + 1, col, visited, flip);
        helper(board, row - 1, col, visited, flip);
        helper(board, row, col + 1, visited, flip);
        helper(board, row, col - 1, visited, flip);
    }
}
