package leetcode._1_50._9;
/*
9. Palindrome Number
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class LC_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        int num = x;
        while (num / div >= 10) {
            div *= 10;
        }
        while (num != 0) {
            int left = num / div;
            int right = num % 10;
            if (left != right) {
                return false;
            }
            num = (num - left * div) / 10;
            div /= 100;
        }
        return true;
    }
}
