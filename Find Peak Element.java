//I
class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length <= 2) {
            return -1;
        }
        int start = 0, end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            }
            else if (A[mid] < A[mid - 1]) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return -1;
    }
}

//II
class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        if (A == null || A.length < 3 ||  A[0].length < 3) {
            return null;
        }
        List<Integer> peak = new ArrayList<Integer>();
        int x = 1, y = 1;
        while (true) {
            int max_x = x, max_y = y;
            if (A[x-1][y] > A[x][y]) {
                max_x = x - 1;
            }
            if (A[x+1][y] > A[max_x][max_y]) {
                max_x = x + 1;
            }
            if (A[x][y-1] > A[max_x][max_y]) {
                max_y = y - 1;
            }
            if (A[x][y+1] > A[max_x][max_y]) {
                max_y = y + 1;
            }
            if (max_x == x && max_y == y) {
                peak.add(x); peak.add(y);
                return peak;
            }
            else {
                x = max_x;
                y = max_y;
            }
        }
    }
}
