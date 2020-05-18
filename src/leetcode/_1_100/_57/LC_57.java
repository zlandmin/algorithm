package leetcode._1_100._57;

import leetcode.common.Interval;

import java.util.ArrayList;
import java.util.List;
/*
57. Insert Interval
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class LC_57 {
    public List<Interval> insert(List<Interval> intervals, Interval insert) {
        List<Interval> result = new ArrayList<>();
        int index = 0;
        while (index < intervals.size() && intervals.get(index).getEnd() <= insert.getStart()) {
            result.add(intervals.get(index));
            index++;
        }
        while (index < intervals.size() && intervals.get(index).getStart() <= insert.getEnd()) {
            insert = new Interval(Math.min(insert.getStart(), intervals.get(index).getStart()),
                    Math.max(insert.getEnd(), intervals.get(index).getEnd()));
            index++;
        }

        result.add(insert);
        while (index < intervals.size()) {
            result.add(intervals.get(index));
            index++;
        }
        return result;
    }
}
