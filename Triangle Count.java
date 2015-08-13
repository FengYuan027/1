public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if (S == null || S.length < 3) {
            return 0;
        }
        Arrays.sort(S);
        int total = 0;
        for (int i = S.length - 1; i >= 2; i--) {
            int start = 0, end = i - 1;
            while (start < end) {
                if (S[start] + S[end] > S[i]) {
                    total += end - start;
                    end--;
                }
                else start++;
            }
        }
        return total;
    }
}
