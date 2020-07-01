package leetcode._1_50._30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
30. Substring with Concatenation of All Words
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []
 */
public class LC_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int m = words.length;
        int n = words[0].length();
        Map<String, Integer> map = new HashMap<>();

        for (String str : words) {
            map.put(str, map.getOrDefault(str,0) + 1);
        }

        for (int i = 0; i <= s.length() - m * n; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = m;
            int j = i;
            while (k > 0) {
                String str = s.substring(j, j + n);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                k--;
                j += n;
            }
            if (k == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
