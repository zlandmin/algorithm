package leetcode._1_100._43;
/*
43. Multiply Strings
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class LC_43 {
    public String multiply(String num1, String num2) {
        int[] pos = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int lowPos = i + j + 1;
                int highPos = i + j;
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product + pos[lowPos];
                pos[lowPos] = sum % 10;
                pos[highPos] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : pos) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return (sb.length() == 0) ? "0" : sb.toString();
    }
}
