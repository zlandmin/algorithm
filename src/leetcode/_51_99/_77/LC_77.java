package leetcode._51_99._77;

import java.util.ArrayList;
import java.util.List;

/*
77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class LC_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        helper(new ArrayList<>(), k, 0, nums, res);
        return res;
    }

    private void helper(List<Integer> cur, int k, int start, int[] nums, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
        } else if (cur.size() < k) {
            for (int i = start; i < nums.length; i++) {
                cur.add(nums[i]);
                helper(cur, k, i + 1, nums, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
