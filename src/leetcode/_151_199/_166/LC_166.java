package leetcode._151_199._166;

import java.util.HashMap;
import java.util.Map;

/*
166. Fraction to Recurring Decimal
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
 */
public class LC_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        String sign = (numerator > 0) ^ (denominator > 0) ? "-" : "";
        if (numerator == 0) {
            return "0";
        }

        long num = Math.abs((long) numerator);
        long deno = Math.abs((long) denominator);
        StringBuilder sb = new StringBuilder();
        sb.append(sign);

        long integral = num / deno;
        sb.append(integral);
        if (numerator % denominator == 0) {
            return sb.toString();
        } else {
            sb.append(".");
        }

        long remain = num % deno;
        Map<Long, Integer> map = new HashMap<>();
        while (!map.containsKey(remain)) {
            map.put(remain, sb.length());
            long n = remain * 10 / deno;
            remain = remain * 10 % deno;
            if (remain != 0 || (remain == 0 && !map.containsKey(remain))) {
                sb.append(n);
            }
        }
        if (remain != 0) {
            sb.insert(map.get(remain), "(");
            sb.append(")");
        }

        return sb.toString();
    }
}
