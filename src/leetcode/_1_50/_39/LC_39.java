package leetcode._1_50._39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
39. Combination Sum
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
public class LC_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, target, 0, new ArrayList<>(), candidates);
        return res;
    }

    private void helper(List<List<Integer>> res, int target, int start, List<Integer> cur, int[] candidates) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                cur.add(candidates[i]);
                helper(res, target - candidates[i], i, cur, candidates);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
