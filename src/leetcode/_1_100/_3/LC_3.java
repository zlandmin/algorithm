package leetcode._1_100._3;
/*
3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LC_3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        int left = 0, right = 0;
        boolean[] chars = new boolean[128];
        while (right < len) {
            if (chars[s.charAt(right)] == false) {
                chars[s.charAt(right)] = true;
                right++;
            } else {
                max = Math.max(max, right - left);
                while (left < right && s.charAt(right) != s.charAt(left)) {
                    chars[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        max = Math.max(max, right - left);

        return max;
    }
}
