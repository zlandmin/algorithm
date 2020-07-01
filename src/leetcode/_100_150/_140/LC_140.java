package leetcode._100_150._140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
140. Word Break II
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 */
public class LC_140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<>());
    }

    private List<String> helper(String s, List<String> wordList, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (String word : wordList) {
            if (s.startsWith(word)) {
                List<String> partRes = helper(s.substring(word.length()), wordList, map);
                for (String sub : partRes) {
                    result.add(word + (sub.length() == 0 ? "" : " ") + sub);
                }
            }
        }

        map.put(s, result);
        return result;
    }
}
