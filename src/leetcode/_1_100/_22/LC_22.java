package leetcode._1_100._22;

import java.util.ArrayList;
import java.util.List;

/*
22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class LC_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }

    private void helper(List<String> res, String cur, int left, int right, int n) {
        if (cur.length() == n * 2) {
            res.add(cur);
            return;
        }
        if (left < n) {
            helper(res, cur + "(", left + 1, right, n);
        }
        if (right < left) {
            helper(res, cur + ")", left, right + 1, n);
        }
    }
}
