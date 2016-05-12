/*
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
*/

public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        ArrayList<Integer> xLocations = new ArrayList<>(), yLocations = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xLocations.add(i);
                    yLocations.add(j);
                }
            }
        }
        return getMinDistance(xLocations) + getMinDistance(yLocations);
    }
    
    private int getMinDistance(ArrayList<Integer> locations) {
        Collections.sort(locations);
        int distance = 0, left = 0, right = locations.size() - 1;
        while (left < right) {
            distance += locations.get(right--) - locations.get(left++);
        }
        return distance;
    }
}
