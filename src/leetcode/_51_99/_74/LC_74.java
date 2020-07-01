package leetcode._51_99._74;
/*
74. Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 */
public class LC_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int start = 0;
        int end = m - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[end][0] <= target) {
            startRow = end;
        } else if (matrix[start][0] <= target) {
            startRow = start;
        }

        start = 0;
        end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[startRow][mid] == target) {
                return true;
            } else if (matrix[startRow][mid] > target) {
                end = mid;
            } else
                start = mid;
        }

        if (matrix[startRow][start] == target) {
            return true;
        } else if (matrix[startRow][end] == target) {
            return true;
        } else
            return false;
    }
}
