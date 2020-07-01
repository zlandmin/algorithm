package leetcode._1_50._16;

import java.util.Arrays;

/*
16. 3Sum Closest
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class LC_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        if (nums.length < 3) {
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }

        sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - curSum) < Math.abs(target - sum)) {
                    sum = curSum;
                    if (sum == target) {
                        return sum;
                    }
                } else if (target > curSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return sum;
    }
}
