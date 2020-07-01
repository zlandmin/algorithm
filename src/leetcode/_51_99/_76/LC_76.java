package leetcode._51_99._76;
/*
76. Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class LC_76 {
    public String minWindow(String s, String t) {
        String res = "";
        int[] target = new int[256];
        int[] store = new int[256];
        for (char c : t.toCharArray()) {
            target[c]++;
        }
        int left = findNextIdx(0, s, target);
        if (left == s.length()) {
            return "";
        }
        int right = left;
        int matchChar = 0;
        while (right < s.length()) {
            int rightChar = s.charAt(right);
            if (store[rightChar] < target[rightChar]) {
                matchChar++;
            }
            store[rightChar]++;
            while (left < s.length() && matchChar == t.length()) {
                if (res.isEmpty() || res.length() > right - left + 1) {
                    res = s.substring(left, right + 1);
                }
                int leftChar = s.charAt(left);
                if (store[leftChar] <= target[leftChar]) {
                    matchChar--;
                }
                store[leftChar]--;
                left = findNextIdx(left + 1, s, target);
            }
            right = findNextIdx(right + 1, s, target);
        }
        return res;
    }

    private int findNextIdx(int start, String s, int[] t) {
        while (start < s.length()) {
            char c = s.charAt(start);
            if (t[c] != 0) {
                return start;
            }
            start++;
        }

        return start;
    }
}
