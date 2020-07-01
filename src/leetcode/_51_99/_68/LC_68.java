package leetcode._51_99._68;

import java.util.ArrayList;
import java.util.List;

/*
68. Text Justification
Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
Example 1:

Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 */
public class LC_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int index = 0;
        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < n) {
                if (totalChars + words[last].length() + 1 > maxWidth) {
                    break;
                }
                totalChars += words[last].length() + 1;
                last++;
            }

            int gaps = last - index - 1;
            StringBuilder sb = new StringBuilder();
            if (last == n || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            }
            else {
                int spaces = (maxWidth - totalChars) / gaps;
                int rest = (maxWidth - totalChars) % gaps;

                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]).append(" ");
                    for (int j = 0; j < spaces + (i - index < rest ? 1 : 0); j++) {
                        sb.append(" ");
                    }
                }
                sb.append(words[last - 1]);
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }
}
