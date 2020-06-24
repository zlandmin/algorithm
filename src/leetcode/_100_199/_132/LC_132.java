package leetcode._100_199._132;

/*
132. Palindrome Partitioning II
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class LC_132 {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] isPal = getAllPalindrome(s);
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                if (isPal[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[s.length()] - 1;
    }

    private boolean[][] getAllPalindrome(String s) {
        boolean[][] isPal = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPal[i][i] = true;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            isPal[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int len = 2; len < s.length(); len++) {
            for (int start = 0; start + len < s.length(); start++) {
                isPal[start][start + len] = isPal[start + 1][start + len - 1] && s.charAt(start) == s.charAt(start + len);
            }
        }

        return isPal;
    }
}
