public class Solution1 {
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

public class Solution2 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> skyline = new ArrayList<int[]>();
        if (buildings.length == 0) return skyline;
        List<int[]> points = new ArrayList<int[]>();
        for (int[] building : buildings) {
            points.add(new int[]{building[0], building[2]});
            points.add(new int[]{building[1], -building[2]});
        }
        Collections.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
        maxHeap.add(0);
        int prev = 0;
        for (int[] point : points) {
            if (point[1] > 0) {
                maxHeap.offer(point[1]);
            }
            else {
                maxHeap.remove(-point[1]);
            }
            int current = maxHeap.peek();
            if (current != prev) {
                skyline.add(new int[]{point[0], current});
                prev = current;
            }
        }
        return skyline;
    }
}
