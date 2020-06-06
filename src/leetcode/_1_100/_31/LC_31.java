package leetcode._1_100._31;

import com.sun.jmx.snmp.SnmpNull;

/*
31 Next Permutation
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class LC_31 {
    public void nextPermutation(int[] nums) {
        int place = nums.length - 2;
        while (place >= 0 && nums[place] >= nums[place + 1]) {
            place--;
        }
        if (place >= 0) {
            int i = place + 1;
            while (i < nums.length && nums[i] > nums[place]) {
                i++;
            }
            i--;
            swap(nums, place, i);
        }

        reverse(nums, place + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int place, int i) {
        int temp = nums[place];
        nums[place] = nums[i];
        nums[i] = temp;
    }
}
