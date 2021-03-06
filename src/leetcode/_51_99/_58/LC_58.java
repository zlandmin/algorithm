package leetcode._51_99._58;
/*
58. Length of Last Word
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5
 */
public class LC_58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.trim();
        int n = s.length() - 1;
        while (n >= 0 && s.charAt(n) != ' ') {
            n--;
        }
        return s.length() - n - 1;
    }
}
