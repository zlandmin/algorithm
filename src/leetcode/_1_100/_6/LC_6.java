package leetcode._1_100._6;
/*
6. ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */
public class LC_6 {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int i = 0;
        while (i < s.length()) {
            for (int index = 0; index < numRows && i < s.length(); index++) {
                sbs[index].append(s.charAt(i++));
            }
            for (int index = numRows - 2; index >= 1 && i < s.length(); index--) {
                sbs[index].append(s.charAt(i++));
            }
        }

        for (int k = 1; k < numRows; k++) {
            sbs[0].append(sbs[k]);
        }
        return sbs[0].toString();
    }
}
