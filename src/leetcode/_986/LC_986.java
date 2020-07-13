package leetcode._986;

import java.util.ArrayList;
import java.util.List;

/**
 * 986. Interval List Intersections
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *
 *
 * Note:
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 */
public class LC_986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int len1 = A.length;
        int len2 = B.length;
        List<int[]> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            int s1 = A[i][0];
            int e1 = A[i][1];
            int s2 = B[j][0];
            int e2 = B[j][1];

            if (s2 > e1) {
                i++;
            } else if (s1 > e2) {
                j++;
            } else {
                int[] a = new int[2];
                a[0] = Math.max(s1, s2);
                a[1] = Math.min(e1, e2);
                res.add(a);
                if (e1 > e2) {
                    j++;
                } else
                    i++;
            }
        }

        int n = res.size();
        int[][] arr = res.toArray(new int[n][2]);
        return arr;
    }
}
