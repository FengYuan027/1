/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution1 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> updated = new ArrayList<Interval>();
        boolean startInserted = false, endInserted = false;
        Interval last = null;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (!startInserted && newInterval.start <= interval.end) {
                startInserted = true;
                if (newInterval.end < interval.start) {
                    updated.add(newInterval);
                    updated.add(interval);
                    endInserted = true;
                }
                else {
                    interval.start = Math.min(interval.start, newInterval.start);
                    interval.end = Math.max(interval.end, newInterval.end);
                    updated.add(interval);
                }
                last = interval;
            }
            else if (startInserted && !endInserted) {
                if (interval.start <= last.end) {
                    last.end = Math.max(last.end, interval.end);
                }
                else {
                    endInserted = true;
                    updated.add(interval);
                }
            }
            else updated.add(interval);
        }
        if (!startInserted) updated.add(newInterval);
        return updated;
    }
}

public class Solution2 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int index = 0;
        List<Interval> inserted = new ArrayList<Interval>();
        while (index < intervals.size() && intervals.get(index).end < newInterval.start) {
            inserted.add(intervals.get(index++));
        }
        if (index == intervals.size() || intervals.get(index).start > newInterval.end) {
            inserted.add(newInterval);
        }
        else {
            Interval interval = new Interval(Math.min(newInterval.start, intervals.get(index).start),
                                            Math.max(newInterval.end, intervals.get(index).end));
            inserted.add(interval);
            index++;
            while (index < intervals.size() && intervals.get(index).start <= interval.end) {
                interval.end = Math.max(interval.end, intervals.get(index++).end);
            }
        }
        while (index < intervals.size()) {
            inserted.add(intervals.get(index++));
        }
        return inserted;
    }
}

public class Solution3 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int index = 0;
        List<Interval> inserted = new ArrayList<Interval>();
        while (index < intervals.size() && intervals.get(index).end < newInterval.start) {
            inserted.add(intervals.get(index++));
        }
        while (index < intervals.size() && intervals.get(index).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(index).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(index).end);
            index++;
        }
        inserted.add(newInterval);
        while (index < intervals.size()) {
            inserted.add(intervals.get(index++));
        }
        return inserted;
    }
}
