package leetcode._100_199._128;

import java.util.HashSet;
import java.util.Set;

/*
128. Longest Consecutive Sequence
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LC_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max_len = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int cur_len = 1;

                while (set.contains(curNum + 1)) {
                    curNum++;
                    cur_len++;
                }
                max_len = Math.max(max_len, cur_len);
            }
        }
        return max_len;
    }
}
