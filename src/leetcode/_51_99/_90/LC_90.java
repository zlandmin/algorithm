package leetcode._51_99._90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
90. Subsets II
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class LC_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,true, new ArrayList<>(), nums, res);
        return res;
    }

    private void helper(int start, boolean taken, List<Integer> cur, int[] nums, List<List<Integer>> res) {
        if (start == nums.length) {
            res.add(new ArrayList<>(cur));
        } else {
            helper(start + 1,false, cur, nums, res);
            if (taken || nums[start] != nums[start - 1]) {
                cur.add(nums[start]);
                helper(start + 1, true, cur, nums, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
