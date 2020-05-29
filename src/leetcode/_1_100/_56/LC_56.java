package leetcode._1_100._56;

import leetcode.common.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*
56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class LC_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 0) {
            return intervals;
        }

        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i < intervals.length && end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
                i++;
            }
            res.add(new int[]{start, end});
            i--;
        }
        int[][] arr = new int[res.size()][2];
        return res.toArray(arr);
    }
}
