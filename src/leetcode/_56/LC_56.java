package leetcode._56;

import leetcode.common.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, (o1, o2) -> o1.getStart() - o2.getStart());
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            int start = intervals.get(i).getStart();
            int end = intervals.get(i).getEnd();
            while (i < intervals.size() && end >= intervals.get(i).getStart()) {
                end = Math.max(end, intervals.get(i).getEnd());
                i++;
            }
            result.add(new Interval(start, end));
            i--;
        }

        return result;
    }
}
