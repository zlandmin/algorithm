package leetcode._1_100._41;

import com.sun.jmx.snmp.SnmpNull;

/*
41. First Missing Positive
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
 */
public class LC_41 {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] != i + 1 && nums[i] - 1 < nums.length && nums[i] != nums[nums[i] - 1]) {
                swapNums(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        return nums.length + 1;
    }

    private void swapNums(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
