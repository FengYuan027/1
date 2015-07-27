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
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> numberOfIslands = new ArrayList<Integer>();
        if (n <= 0 || m <= 0 || operators == null || operators.length == 0) {
            return numberOfIslands;
        }
        int number = 0;
        int islandTag = 1;
        int[][] map = new int[n][m];
        Hashtable<Integer, Integer> unionFind = new Hashtable<Integer, Integer>();
        for (int i = 0; i < operators.length; i++) {
            int x = operators[i].x, y = operators[i].y;
            ArrayList<Integer> neighborParents = findNeighborParent(unionFind, map, x, y);
            if (neighborParents.isEmpty()) {
                map[x][y] = islandTag;
                number++;
                unionFind.put(islandTag, islandTag);
                islandTag++;
            }
            else {
                int parent = Integer.MAX_VALUE;
                for (int j = 0; j < neighborParents.size(); j++) {
                    parent = Math.min(parent, neighborParents.get(j));
                }
                for (int j = 0; j < neighborParents.size(); j++) {
                    int curr_parent = neighborParents.get(j);
                    if (unionFind.get(curr_parent) != parent) {
                        unionFind.put(curr_parent, parent);
                        number--;
                    }
                }
                map[x][y] = parent;
            }
            numberOfIslands.add(number);
        }
        return numberOfIslands;
    }
    
    public ArrayList<Integer> findNeighborParent(Hashtable<Integer, Integer> unionFind, int[][] map, int x, int y) {
        ArrayList<Integer> parents = new ArrayList<Integer>();
        if (x-1 >= 0 && map[x-1][y] > 0) {
            parents.add(findParent(unionFind, map[x-1][y]));
        }
        if (x+1 < map.length && map[x+1][y] > 0) {
            parents.add(findParent(unionFind, map[x+1][y]));
        }
        if (y-1 >= 0 && map[x][y-1] > 0) {
            parents.add(findParent(unionFind, map[x][y-1]));
        }
        if (y+1 < map[0].length && map[x][y+1] > 0) {
            parents.add(findParent(unionFind, map[x][y+1]));
        }
        return parents;
    }
    
    public int findParent(Hashtable<Integer, Integer> unionFind, int tag) {
        while (unionFind.get(tag) != tag) {
            tag = unionFind.get(tag);
        }
        return tag;
    }
}
