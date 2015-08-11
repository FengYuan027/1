/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> merged = new ArrayList<Interval>();
        if (intervals == null) {
            return merged;
        }
        Collections.sort(intervals, new IntervalComparator());
        for (Interval interval: intervals) {
            if (merged.isEmpty()) {
                merged.add(new Interval(interval.start, interval.end));
            }
            else {
                Interval last = merged.get(merged.size() - 1);
                if (last.end >= interval.start) {
                    last.end = Math.max(last.end, interval.end);
                }
                else {
                    merged.add(new Interval(interval.start, interval.end));
                }
            }
        }
        return merged;
    }
    
    public class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval v1, Interval v2) {
            if (v1.start < v2.start) {
                return -1;
            }
            else if (v1.start > v2.start) {
                return 1;
            }
            return 0;
        }
    }
}
