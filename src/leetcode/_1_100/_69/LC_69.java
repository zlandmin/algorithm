package leetcode._1_100._69;
/*
69. Sqrt(x)
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 */
public class LC_69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 1, end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // writing in this way instead of "nums[mid] * nums[mid]" to avoid overflow
            if (mid == x / mid)
                return mid;
            else if (mid < x / mid)
                start = mid;
            else
                end = mid;
        }
        if (end > x / end)  return start;
        return end;
    }
}
