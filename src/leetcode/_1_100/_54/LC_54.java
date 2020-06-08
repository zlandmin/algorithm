package leetcode._1_100._54;

import java.util.ArrayList;
import java.util.List;

/*
54. Spiral Matrix
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class LC_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int buttom = matrix.length - 1;

        while (left < right && top < buttom) {
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            for (int i = top; i < buttom; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                res.add(matrix[buttom][i]);
            }
            for (int i = buttom; i > top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            buttom--;
        }

        if (left == right) {
            for (int i = top; i <= buttom; i++) {
                res.add(matrix[i][left]);
            }
        } else if (top == buttom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
        }

        return res;
    }
}
