class Solution {
    /**
      * @param n: n
      * @param k: the kth permutation
      * @return: return the k-th permutation
      */
    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) {
            return "";
        }
        int[] nums = new int[n];
        int pivot = 1;
        for (int i = 1; i <= n; i++) {
            pivot *= i;
            nums[i-1] = i;
        }
        k--;
        pivot /= n;
        int index = 0;
        while (k > 0 && index < n - 1) {
            int targetIndex = k / pivot + index;
            int temp = nums[targetIndex];
            for (int j = targetIndex; j > index; j--) {
                nums[j] = nums[j-1];
            }
            nums[index] = temp;
            k %= pivot;
            pivot /= (n - index - 1);
            index++;
        }
        String perm = "";
        for (int i = 0; i < n; i++) {
            char c = (char)((int)'0' + nums[i]);
            perm = perm + c;
        }
        return perm;
    }
}
