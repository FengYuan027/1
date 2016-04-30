public class Solution {
    public int climbStairs(int n) {
        if (n < 1) return 0;
        int lastTwo = 1, lastOne = 1, step = 1;
        while (n-- > 1) {
            step = lastOne + lastTwo;
            lastTwo = lastOne;
            lastOne = step;
        }
        return step;
    }
}
