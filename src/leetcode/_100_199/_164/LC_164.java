package leetcode._100_199._164;

/*
164. Maximum Gap
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
 */

public class LC_164 {
    class Bucket {
        public int max;
        public int min;
        public Bucket() {
            this.max = 0;
            this.min = Integer.MAX_VALUE;
        }
        public void upateWithNum(int num) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
    }
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        Bucket[] buckets = new Bucket[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            buckets[i] = new Bucket();
        }
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (max == min) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            int index = findIndex(nums[i], max, min, nums.length - 1);
            buckets[index].upateWithNum(nums[i]);
        }
        int res = 0;
        int curMin = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (buckets[i].min == Integer.MAX_VALUE) {
                continue;
            }
            res = Math.max(res, buckets[i].min - curMin);
            curMin = buckets[i].max;
        }

        return res;
    }

    private int findIndex(int num, int max, int min, int n) {
        float size = (float) (max - min) / n;
        return (int) Math.min(n - 1, (num - min) / size);
    }
}
