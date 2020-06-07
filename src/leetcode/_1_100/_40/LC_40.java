package leetcode._1_100._40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
40. Combination Sum II
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */
public class LC_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                if (candidates[i] > target || (i > start && candidates[i] == candidates[i - 1])) {
                    continue;
                }
                cur.add(candidates[i]);
                helper(res, target - candidates[i], i + 1, cur, candidates);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
