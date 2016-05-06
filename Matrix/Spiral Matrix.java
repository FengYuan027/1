/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. 
*/

public class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return nums;
        int M = matrix.length, N = matrix[0].length, minD = Math.min(M, N);
        for (int i = 0; i < minD/2 + minD%2; i++) {
            int left = i, right = N - 1 - i, top = i, down = M - 1 - i;
            for (int j = left; j <= right; j++) {
                nums.add(matrix[top][j]);
            }
            for (int j = top + 1; j <= down; j++) {
                nums.add(matrix[j][right]);
            }
            if (down > top) {
                for (int j = right - 1; j >= left; j--) {
                    nums.add(matrix[down][j]);
                }
            }
            if (right > left) {
                for (int j = down - 1; j > top; j--) {
                    nums.add(matrix[j][left]);
                }
            }
        }
        return nums;
    }
}

public class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }
}
