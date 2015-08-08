public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int N = height.length;
        int[] edge = new int[N];
        int max_height = height[0];
        for (int i = 0; i < N; i++) {
            max_height = Math.max(max_height, height[i]);
            edge[i] = max_height;
        }
        max_height = height[N-1];
        for (int i = N - 1; i >= 0; i--) {
            max_height = Math.max(max_height, height[i]);
            edge[i] = Math.min(max_height, edge[i]);
        }
        max_height = 0;
        for (int i = 0; i < N; i++) {
            max_height += (edge[i] - height[i]);
        }
        return max_height;
    }
}
