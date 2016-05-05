/*
There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers. 
*/

public class Solution {
    public int numWays(int n, int k) {
        if (n <= 0 || k < 2 && n > 2) return 0;
        int same = 0, unsame = k;
        for (int i = 1; i < n; i++) {
            int nextSame = unsame;
            unsame = (k-1) * (same + unsame);
            same = nextSame;
        }
        return same + unsame;
    }
}
