public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n <= 1) {
            return 1;
        }
        int last1 = 1, last2 = 1;
        while (n-- > 1) {
            last2 += last1;
            last1 = last2 - last1;
        }
        return last2;
    }
}

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        if (m < 1 || n < 1) {
            return 0;
        }
        int[] paths = new int[n];
        for (int i = 0; i < n; i++) {
            paths[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[j] += paths[j-1];
            }
        }
        return paths[n-1];
    }
}

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] paths = new int[n];
        paths[0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                paths[i] = 0;
            }
            else {
                paths[i] = paths[i-1];
            }
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                paths[0] = 0;
            }
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    paths[j] = 0;
                }
                else {
                    paths[j] += paths[j-1];
                }
            }
        }
        return paths[n-1];
    }
}
