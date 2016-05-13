public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        return mergeBuilding(buildings, 0, buildings.length - 1);
    }
    
    public List<int[]> mergeBuilding(int[][] buildings, int start, int end) {
        List<int[]> merged = new ArrayList<int[]>();
        if (start > end) return merged;
        if (start == end) {
            merged.add(new int[]{buildings[start][0], buildings[start][2]});
            merged.add(new int[]{buildings[start][1], 0});
            return merged;
        }
        int mid = start + (end - start) / 2;
        List<int[]> left = mergeBuilding(buildings, start, mid), right = mergeBuilding(buildings, mid + 1, end);
        int leftI = 0, rightI = 0, leftH = -1, rightH = 0;
        while (leftI < left.size() && rightI < right.size()) {
            int x = Math.min(left.get(leftI)[0], right.get(rightI)[0]);
            if (x == left.get(leftI)[0]) {
                leftH = left.get(leftI++)[1];
            }
            if (x == right.get(rightI)[0]) {
                rightH = right.get(rightI++)[1];
            }
            int currentH = Math.max(leftH, rightH);
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] != currentH) merged.add(new int[]{x, currentH});
        }
        while (leftI < left.size()) merged.add(left.get(leftI++));
        while (rightI < right.size()) merged.add(right.get(rightI++));
        return merged;
    }
}
