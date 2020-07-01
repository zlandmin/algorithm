package leetcode._100_150._120;

import java.util.List;
/*
120. Triangle
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class LC_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            int m = triangle.get(i).size();
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][m-1] = dp[i-1][m-2] + triangle.get(i).get(m-1);
            for (int j = 1; j < m - 1; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
        }
        int res = dp[n-1][0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, dp[n-1][i]);
        }
        return res;
    }
}
