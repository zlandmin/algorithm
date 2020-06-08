package leetcode._1_100._47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
47. Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class LC_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> out = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, rst, out, visited);
        return rst;
    }

    private void helper(int[] nums, List<List<Integer>> rst, List<Integer> out, boolean[] visited) {
        if (out.size() == nums.length) {
            rst.add(new ArrayList<>(out));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            out.add(nums[i]);
            visited[i] = true;
            helper(nums, rst, out, visited);
            out.remove(out.size() - 1);
            visited[i] = false;
        }
    }
}
