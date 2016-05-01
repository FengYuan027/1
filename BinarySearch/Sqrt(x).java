public class Solution {
    public int mySqrt(int x) {
        if (x < 1) return 0;
        int start = 1, end = Math.max(1, Math.min((int)Math.sqrt(Integer.MAX_VALUE), x/2));
        while (start <= end) {
            int mid = (start + end) / 2, square = mid * mid;
            if (square == x) return mid;
            else if (square < x) start = mid + 1;
            else end = mid - 1;
        }
        return start - 1;
    }
}
