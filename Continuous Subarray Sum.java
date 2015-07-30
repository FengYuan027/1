public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(-1);
        result.add(-1);
        if (A == null || A.length == 0) return result;
        int max_sum = A[0], prev = 0, curr_sum = A[0];;
        result.set(0, 0); result.set(1,0);
        for (int i = 1; i < A.length; i++) {
            if (curr_sum < 0) {
                curr_sum = 0;
                prev = i;
            }
            curr_sum += A[i];
            if (curr_sum > max_sum) {
                result.set(0, prev);
                result.set(1, i);
                max_sum = curr_sum;
            }
        }
        return result;
    }
}
