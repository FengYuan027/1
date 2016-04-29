public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] < target) start = mid + 1;
            else end = mid - 1;
        }
        if (end < 0) return false;
        int row = end;
        start = 0;
        end = matrix[0].length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}

public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length, N = matrix[0].length, start = 0, end = M*N-1;
        while (start <= end) {
            int mid = (start + end) / 2, val = matrix[mid/N][mid%N];
            if (val == target) return true;
            else if (val < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
