package leetcode._1_100._5;
/*
5. Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
public class LC_5 {
    private int start;
    private int maxLen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }

        return s.substring(start, start + maxLen);
    }

    private void helper(String str, int left, int right) {
        while (left >= 0 && right <= str.length() - 1 && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            start = left + 1;
            maxLen = right - left - 1;
        }
    }
}
