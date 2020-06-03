package leetcode._1_100._84;

import java.util.Stack;

/*
84. Largest Rectangle in Histogram
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:

Input: [2,1,5,6,2,3]
Output: 10
 */
public class LC_84 {
    public int largestRectangleArea(int[] heights) {
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
