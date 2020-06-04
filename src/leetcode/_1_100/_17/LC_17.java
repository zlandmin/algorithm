package leetcode._1_100._17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LC_17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character, char[]> map = new HashMap(){{
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r', 's'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y', 'z'});
        }};
        helper("", 0, digits, map, res);
        return res;
    }

    private void helper(String cur, int idx, String digits, Map<Character, char[]> map, List<String> res) {
        if (idx == digits.length()) {
            res.add(cur);
        }
        else {
            char ch = digits.charAt(idx);
            if (map.containsKey(ch)) {
                for (char c : map.get(ch)) {
                    helper(cur + c, idx + 1, digits, map, res);
                }
            }
        }
    }
}
