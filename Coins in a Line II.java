public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false;
        }
        if (values.length <= 2) {
            return true;
        }
        int N = values.length;
        int[] max_amount = new int[N];
        max_amount[N-1] = values[N-1];
        max_amount[N-2] = values[N-1] + values[N-2];
        for (int i = N - 3; i >= 0; i--) {
            max_amount[i] = Math.max(values[i] - max_amount[i+1], values[i] + values[i+1] - max_amount[i+2]);
        }
        return max_amount[0] > 0;
    }
}
