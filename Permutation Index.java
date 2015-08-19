public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        long index = 1;
        long pivot = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            int count = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
            index += count * pivot;
            pivot *= (A.length - i);
        }
        
        return index;
    }
}
