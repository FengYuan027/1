public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> s = new Stack<Integer>();
        int N = height.length, max_area = 0;
        for (int i = 0; i <= N; i++) {
            while (!s.empty() && ( i < N && height[s.peek()] >= height[i] || i == N)) {
                int index = s.pop();
                int curr_area = (s.empty()? i : i - s.peek() - 1) * height[index];
                max_area = Math.max(max_area, curr_area);
            }
            s.push(i);
        }
        return max_area;
    }
}
