/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        // Write your code here
        if (points == null || points.length < 1) return 0;
        int max_points = 0;
        for (int i = 0; i < points.length; i++) {
            Hashtable<Double, Integer> slopes = new Hashtable<Double, Integer>();
            int same_p = 0, vertical = 0, curr_max = 0;
            int x = points[i].x, y = points[i].y;
            for (int j = i + 1; j < points.length; j++) {
                int m = points[j].x, n = points[j].y;
                if (x == m) {
                    if (y == n) same_p++;
                    else vertical++;
                }
                else {
                    double k = (n - y) * 1.0 / ((m - x) * 1.0);
                    if (slopes.containsKey(k)) {
                        slopes.put(k, slopes.get(k) + 1);
                    }
                    else {
                        slopes.put(k, 1);
                    }
                    curr_max = Math.max(curr_max, slopes.get(k));
                }
            }
            max_points = Math.max(Math.max(curr_max, vertical) + 1 + same_p, max_points);
        }
        return max_points;
    }
}
