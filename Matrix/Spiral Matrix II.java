/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,
You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][];
        int[][] matrix = new int[n][n];
        for (int i = 0, k = 1; i < n/2 + n%2; i++) {
            int left = i, right = n - i - 1, top = i, down = n - i - 1;
            for (int j = left; j <= right; j++) {
                matrix[top][j] = k++;
            }
            for (int j = top + 1; j <= down; j++) {
                matrix[j][right] = k++;
            }
            for (int j = right - 1; j >= left ; j--) {
                matrix[down][j] = k++;
            }
            for (int j = down - 1; j > top; j--) {
                matrix[j][left] = k++;
            }
        }
        return matrix;
    }
}
