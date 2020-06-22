package leetcode._100_199._127;

import java.util.*;

/*
127. Word Ladder
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class LC_127 {
    Map<String, List<String>> loopUp = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        buildMap(wordList, beginWord);
        Queue<String> queue = new LinkedList<>();
        Set<String> doneSet = new HashSet<>();
        int steps = 1;
        queue.offer(beginWord);
        doneSet.add(beginWord);
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
