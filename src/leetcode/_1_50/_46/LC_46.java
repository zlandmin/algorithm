package leetcode._1_50._46;

import java.util.ArrayList;
import java.util.List;

/*
46. Permutations
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class LC_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(res, new ArrayList<>(), nums, visited);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] visited) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                cur.add(nums[i]);
                visited[i] = true;
                helper(res, cur, nums, visited);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }
}
