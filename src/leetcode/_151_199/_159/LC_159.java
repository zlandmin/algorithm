package leetcode._151_199._159;

import java.util.HashMap;
import java.util.Map;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 *
 * Example 1:
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 *
 * Example 2:
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 */
public class LC_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int index = 0;
        int res = 0;

        while (index < s.length()) {
            map.put(s.charAt(index), index);
            index++;

            if (map.size() > 2) {
                int left = s.length();
                for (int num : map.values()) {
                    left = Math.min(left, num);
                }
                map.remove(s.charAt(left));
                start = left + 1;
            }

            res = Math.max(res, index - start);
        }

        return res;
    }
}
