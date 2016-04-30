public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstColZero = false;
        int M = matrix.length, N = matrix[0].length;
        for (int i = 0; i < M; i++) {
            if (matrix[i][0] == 0) firstColZero = true;
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = M - 1; i >= 0; i--) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
            if (firstColZero) matrix[i][0] = 0;
        }
    }
}
