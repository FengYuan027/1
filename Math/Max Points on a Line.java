/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

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
    public int maxPoints(Point[] points) {
        int maximum = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
            int currentMax = 0, overlap = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) {
                    overlap++;
                }
                else {
                    int commonDivisor = getCommonDivisor(x, y);
                    x /= commonDivisor;
                    y /= commonDivisor;
                    if (map.containsKey(x) && map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    }
                    else {
                        map.computeIfAbsent(x, k-> new HashMap<Integer, Integer>()).put(y, 1);
                    }
                    currentMax = Math.max(currentMax, map.get(x).get(y));
                }
            }
            maximum = Math.max(maximum, currentMax + overlap + 1);
        }
        return maximum;
    }
    
    private int getCommonDivisor(int a, int b) {
        if (b == 0) return a;
        return getCommonDivisor(b, a%b);
    }
}
