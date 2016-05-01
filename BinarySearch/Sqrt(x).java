public class Solution1 {
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

public class Solution2 {
    public int mySqrt(int x) {
        if (x < 1) return 0;
        int start = 1, end = Integer.MAX_VALUE;
        while (true) {
            int mid = start + (end - start) / 2;
            if (mid > x / mid) end = mid - 1;
            else {
                if (mid + 1 > x / (mid + 1)) return mid;
                else start = mid + 1;
            }
        }
    }
}
