public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || k < 1) {
            return 0;
        }
        int start = 1, end =1;
        for (int i = 0; i < L.length; i++) {
            end = Math.max(end, L[i]);
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = 0;
            for (int i = 0; i < L.length; i++) {
                count += L[i] / mid;
            }
            if (count >= k) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return start - 1;
    }
}
