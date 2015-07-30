public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(-1);
        result.add(-1);
        if (A == null || A.length == 0) return result;
        int max_sum = A[0], curr_sum = A[0], prev = 0, total_sum = A[0];
        int min_sum = A[0], curr_min = A[0], min_start = 0, min_end = 0, start = 0;
        result.set(0, 0);
        result.set(1, 0);
        for (int i = 0; i < A.length; i++) {
            if (curr_sum < 0) {
                curr_sum = 0;
                prev = i;
            }
            if (curr_min > 0) {
                curr_min = 0;
                start = i;
            }
            curr_sum += A[i];
            curr_min += A[i];
            total_sum += A[i];
            if (curr_sum > max_sum) {
                max_sum = curr_sum;
                result.set(0, prev);
                result.set(1, i);
            }
            if (curr_min < min_sum) {
                min_sum = curr_min;
                min_start = start;
                min_end = i;
            }
        }
        if (total_sum > min_sum && total_sum - min_sum > max_sum) {
            result.set(0, min_end+1);
            result.set(1, min_start - 1);
        }
        return result;
    }
}
