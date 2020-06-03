package leetcode._1_100._85;

import java.util.Stack;

/*
85. Maximal Rectangle
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
 */
public class LC_85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] - '0' == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int cur = 0; cur < heights.length; cur++) {
            if (stack.isEmpty() || heights[cur] >= heights[stack.peek()]) {
                stack.push(cur);
            }
            else {
                int right = cur;
                int index = stack.pop();
                while (!stack.isEmpty() && heights[index] == heights[stack.peek()]) {
                    index = stack.pop();
                }
                int left = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, (right - left - 1) * heights[index]);
                cur--;
            }
        }
        int right = stack.peek() + 1;
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, (right - left - 1) * heights[index]);
        }
        return max;
    }
}
