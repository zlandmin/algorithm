package leetcode._200_250._204;

import java.util.Arrays;

/**
 * 204. Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class LC_204 {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int count = 0;
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, true);
        flags[0] = false;
        flags[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!flags[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                flags[j] = false;
            }
        }

        for (int i = 2; i < flags.length; i++) {
            if (flags[i]) {
                count++;
            }
        }
        return count;
    }
}
