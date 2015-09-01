public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] sums = new int[n];
        sums[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            sums[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                sums[j] = grid[i][j] + Math.min(sums[j-1], sums[j]);
            }
        }
        return sums[n-1];
    }
}

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x < 0) {
            return -1;
        }
        if (x < 2) {
            return x / 1;
        }
        int start = 2, end = Math.min(x, (int)Math.sqrt(Integer.MAX_VALUE));
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mid * mid < x) {
                start = mid + 1;
            }
            else if (mid * mid > x) {
                end = mid - 1;
            }
            else {
                return mid;
            }
        }
        return (start + end) / 2;
    }
}

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }
        int white = 0, blue = nums.length, index = 0;
        while (index < blue) {
            if (nums[index] == 0) {
                swap(nums, index, white++);
                index++;
            }
            else if (nums[index] == 2) {
                swap(nums, index, --blue);
            }
            else {
                index++;
            }
        }
    }
    
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
