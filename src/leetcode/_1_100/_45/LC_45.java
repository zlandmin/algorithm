package leetcode._1_100._45;
/*
45. Jump Game II
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class LC_45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int step = 0;
        int index = 0;
        int curMax = 0;
        int nextMax = 0;
        while (index <= curMax) {
            while (index <= curMax) {
                nextMax = Math.max(nextMax, index + nums[index]);
                index++;
            }
            curMax = nextMax;
            step++;
            if (curMax >= nums.length - 1) {
                return step;
            }
        }
        return 0;
    }
}
