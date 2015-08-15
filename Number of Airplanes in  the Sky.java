/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        ArrayList<TimeStamp> stamps = new ArrayList<TimeStamp>();
        for (Interval i : airplanes) {
            stamps.add(new TimeStamp(i.start, true));
            stamps.add(new TimeStamp(i.end, false));
        }
        Collections.sort(stamps, new TimeStampCompare());
        int count = 0, max_count = 0;
        for (TimeStamp t : stamps) {
            if (t.left) count++;
            else count--;
            max_count = Math.max(max_count, count);
        }
        return max_count;
    }
    
    public class TimeStamp {
        int time;
        boolean left;
        TimeStamp(int time, boolean left) {
            this.time = time;
            this.left = left;
        }
    }
    
    public class TimeStampCompare implements Comparator<TimeStamp> {
        public int compare(TimeStamp t1, TimeStamp t2) {
            if (t1.time > t2.time) {
                return 1;
            }
            else if (t1.time < t2.time) {
                return -1;
            }
            else {
                if (t1.left == t2.left) {
                    return 0;
                }
                else if (t1.left) {
                    return 1;
                }
                else return -1;
            }
        }
    }
}
