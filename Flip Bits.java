class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int c = a ^ b;
        int count = 0;
        while (c != 0) {
            if ((c&1) != 0) {
                count++;
            }
            c >>>= 1;
        }
        return count;
    }
};
