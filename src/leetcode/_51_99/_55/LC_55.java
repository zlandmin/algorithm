package leetcode._51_99._55;
/*
55. Jump Game
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 3 * 10^4
0 <= nums[i][j] <= 10^5
 */
public class LC_55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int maxReach = 0;
        int index = 0;
        while (index <= maxReach &&  index < nums.length) {
            maxReach = Math.max(maxReach, index + nums[index]);
            index++;
        }
        return maxReach >= nums.length - 1;
    }
}
