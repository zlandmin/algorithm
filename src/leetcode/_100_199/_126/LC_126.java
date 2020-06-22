package leetcode._100_199._126;

import java.util.*;

/*
126. Word Ladder II
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class LC_126 {
    Map<String, List<String>> loopUp = new HashMap<>();
    Map<String, Integer> deepMap = new HashMap<>();

    private void helper(List<String> curList, Set<String> doneSet, List<List<String>> res, String target) {

    }

    private int findLadder(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        buildMap(wordList, beginWord);
        Queue<String> queue = new LinkedList<>();
        Set<String> doneSet = new HashSet<>();
        int steps = 1;
        queue.offer(beginWord);
        doneSet.add(beginWord);
        deepMap.put(beginWord, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return steps;
                }
                if (loopUp.containsKey(cur)) {
                    List<String> list = loopUp.get(cur);
                    for (String str : list) {
                        if (!doneSet.contains(str)) {
                            queue.offer(str);
                            doneSet.add(str);
                            deepMap.put(str, steps);
                        }
                    }
                }
            }
            steps++;
        }

        return 0;
    }

    private void buildMap(List<String> wordList, String beginWord) {
        Set<String> wordSet = new HashSet<>();
        for (String str : wordList) {
            wordSet.add(str);
        }
        wordSet.add(beginWord);
        for (String str : wordSet) {
            loopUp.put(str, new LinkedList<>());
            diff(str, wordSet);
        }
    }

    private void diff(String s, Set<String> wordSet) {
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            char cur = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (cur != c) {
                    sb.setCharAt(i, c);
                    if (wordSet.contains(sb.toString())) {
                        loopUp.get(s).add(sb.toString());
                    }
                }
            }
        }
    }
}
