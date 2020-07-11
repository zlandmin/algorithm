package leetcode._300_399._301;

import java.util.ArrayList;
import java.util.List;

/**
 * 301. Remove Invalid Parentheses
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 */
public class LC_301 {
    char[][] patterns = {{'(', ')'}, {')', '('}};
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(patterns[0], s, 0, 0, res);
        return res;
    }

    private void helper(char[] pattern, String s, int start, int lastRemove, List<String> res) {
        int count = 0;
        int n = s.length();
        for (int i = start; i < n; i++) {
            if (s.charAt(i) == pattern[0]) count++;
            if (s.charAt(i) == pattern[1]) count--;
            if (count < 0) {
                for (int j = lastRemove; j <= i; j++) {
                    char c = s.charAt(j);
                    if (c == pattern[1] && (j == lastRemove || c != s.charAt(j - 1))) {
                        helper(pattern, s.substring(0, j) + s.substring(j + 1), i, j, res);
                    }
                }
                return;
            }
        }
        s = new StringBuilder(s).reverse().toString();
        if (pattern == patterns[0]) {
            helper(patterns[1], s, 0, 0, res);
        } else {
            res.add(s);
        }
    }
}
