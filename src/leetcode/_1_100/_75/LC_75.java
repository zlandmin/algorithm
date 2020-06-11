package leetcode._1_100._75;
/*
75. Sort Colors
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 */
public class LC_75 {
    public void sortColors(int[] nums) {
        int fisrtPos = 0;
        int len = nums.length;
        while (fisrtPos < len && nums[fisrtPos] == 0) {
            fisrtPos++;
        }
        int lastPos = len - 1;
        while (lastPos >= 0 && nums[lastPos] == 2) {
            lastPos--;
        }

        int index = fisrtPos;
        while (index <= lastPos) {
            if (nums[index] == 1) {
                index++;
            } else if (nums[index] == 0) {
                swapNum(nums, index, fisrtPos);
                fisrtPos++;
                index++;
            } else if (nums[index] == 2) {
                swapNum(nums, index, lastPos);
                lastPos--;
            }
        }
    }

    private void swapNum(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
