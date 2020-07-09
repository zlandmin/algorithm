package leetcode._151_199._186;

/**
 * 186. Reverse Words in a String II
 Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 For example,
 Given s = "the sky is blue",
 return "blue is sky the".
 Could you do it in-place without allocating extra space?
 */
public class LC_186 {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        reverse(s, 0, s.length - 1);
        int index = 0;
        int start = 0;
        while (index <= s.length) {
            if (index == s.length || s[index] == ' ') {
                reverse(s, start, index - 1);
                start = index + 1;
            }
            index++;
        }
    }

    private void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
