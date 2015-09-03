public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return Integer.MIN_VALUE;
        }
        return findMin(num, 0, num.length - 1);
    }
    
    private int findMin(int[] num, int start, int end) {
        if (start == end) {
            return num[start];
        }
        int mid = (start + end) / 2;
        if (num[mid] < num[end]) {
            return findMin(num, start, mid);
        }
        else if (num[mid] > num[end]) {
            return findMin(num, mid + 1, end);
        }
        else {
            if (num[start] > num[mid]) {
                return findMin(num, start + 1, mid);
            }
            else if (num[start] < num[mid]) {
                return num[start];
            }
            else {
                return Math.min(findMin(num, start, mid), findMin(num, mid + 1, end));
            }
        }
    }
}

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return Integer.MIN_VALUE;
        }
        int start = 0, end = num.length - 1;
        while (true) {
            if (start == end) {
                return num[start];
            }
            int mid = (start + end) / 2;
            if (num[mid] > num[end]) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
    }
}

class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int mask = 0;
        if (j < 31) {
            mask = ~ ( (1 << (j + 1)) - (1 << i));
        }
        else {
            mask = (1 << i) - 1;
        }
        return (n & mask) | (m << i);
    }
}

