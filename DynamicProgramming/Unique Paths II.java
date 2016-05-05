/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length, N = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[M-1][N-1] == 1) return 0;
        int[] ways = new int[N];
        ways[0] = 1;
        for (int i = 0; i < M; i++) {
            if (obstacleGrid[i][0] == 1) ways[0] = 0;
            for (int j = 1; j < N; j++) {
                if (obstacleGrid[i][j] == 1) ways[j] = 0;
                else ways[j] += ways[j-1];
            }
        }
        return ways[N-1];
    }
}
