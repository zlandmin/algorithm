package leetcode._251_299._252;

import leetcode.common.Interval;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 252. Meeting Rooms
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * Example 1:
 *
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: true
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class LC_252 {
    public boolean canAttendMeetings(Interval[] intervals) {
        List<Interval> list = new ArrayList<>();
        for (Interval interval : intervals) {
            list.add(interval);
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.getStart() > o2.getStart()) {
                return 1;
            } else
                return -1;
        });

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getEnd() > list.get(i + 1).getStart()) {
                return false;
            }
        }
        return true;
    }
}
