public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int[] possible = new int[A.length];
        possible[0] = 1;
        for (int i = 0; i < A.length - 1; i++) {
            if (possible[i] > 0) {
                for (int j = 1; j <= A[i]; j++) {
                    if (i + j >= A.length - 1) return true;
                    possible[i+j] = 1;
                }
            }
        }
        return false;
    }
}
