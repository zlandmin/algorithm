package leetcode._51_99._93;

import java.util.ArrayList;
import java.util.List;

/*
93. Restore IP Addresses
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
 */
public class LC_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() > 12) {
            return res;
        }
        helper(res, s, "", 0);
        return res;
    }

    private void helper(List<String> res, String s, String cur, int field) {
        if (field == 4 && s.length() == 0) {
            res.add(cur.substring(1));
        }
        else if (field == 4 || s.length() == 0) {
            return;
        } else {
            helper(res, s.substring(1), cur + "." + s.substring(0, 1), field + 1);
            if (s.charAt(0) != '0' && s.length() > 1) {
                helper(res, s.substring(2), cur + "." + s.substring(0, 2), field + 1);
                if (s.length() > 2 && Integer.valueOf(s.substring(0, 3)) <= 255) {
                    helper(res, s.substring(3), cur + "." + s.substring(0, 3), field + 1);
                }
            }
        }
    }
}
