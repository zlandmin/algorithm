package leetcode._200_250._202;

import java.util.HashSet;
import java.util.Set;

/*
202. Happy Number
Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 */
public class LC_202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            int temp = 0;
            while (n != 0) {
                int digit = n % 10;
                temp += digit * digit;
                n = n / 10;
            }
            if (!set.add(temp)) {
                return false;
            }
            n = temp;
        }
        return true;
    }
}
