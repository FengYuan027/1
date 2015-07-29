public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int[][] submatrix = new int[2][2];
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return submatrix;
        }
        int M = matrix.length, N = matrix[0].length;
        int[][][] sums = new int[M][N][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = j; k < N; k++) {
                    sums[i][j][k] = matrix[i][k] + (k == j? 0 : sums[i][j][k-1]);
                }
            } 
        }
        for (int j = 0; j < N; j++) {
            for (int k = j; k < N; k++) {
                for (int i = 1; i < M; i++) {
                    sums[i][j][k] += sums[i-1][j][k];
                }
            }
        }
        for (int j = 0; j < N; j++) {
            for (int k = j; k <N; k++) {
                Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
                for (int i = 0; i < M; i++) {
                    if (sums[i][j][k] == 0) {
                        submatrix[0][0] = 0;
                        submatrix[0][1] = j;
                        submatrix[1][0] = i;
                        submatrix[1][1] = k;
                    }
                    else if (map.containsKey(sums[i][j][k])) {
                        submatrix[0][0] = map.get(sums[i][j][k]) + 1;
                        submatrix[0][1] = j;
                        submatrix[1][0] = i;
                        submatrix[1][1] = k;
                    }
                    else map.put(sums[i][j][k], i);
                }
            }
        }
        return submatrix;
    }
}
