package leetcode._51_99._59;
/*
59. Spiral Matrix II
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class LC_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int buttom = n - 1;
        int k = 1;
        while (left < right && top < buttom) {
            for (int i = left; i < right; i++) {
                res[top][i] = k++;
            }
            for (int i = top; i < buttom; i++) {
                res[i][right] = k++;
            }
            for (int i = right; i > left; i--) {
                res[buttom][i] = k++;
            }
            for (int i = buttom; i > top; i--) {
                res[i][left] = k++;
            }
            left++;
            right--;
            top++;
            buttom--;
        }
        if (n % 2 == 1) {
            res[n/2][n/2] = k;
        }

        return res;
    }
}
