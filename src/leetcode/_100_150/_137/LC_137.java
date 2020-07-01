package leetcode._100_150._137;

/*
137. Single Number II
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
 */
public class LC_137 {
//    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap();
//        for (int i : nums) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        for (int key : map.keySet()) {
//            if (map.get(key) != 3) {
//                return key;
//            }
//        }
//        return 0;
//    }
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return nums[0];
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
                sum %= 3;
            }
            res = res | (sum << i);
        }
        return res;
    }
}
