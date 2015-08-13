public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        long divid = (long) dividend;
        long divis = (long) divisor;
        if (divis == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean neg = false;
        if (divid < 0) {
            divid = 0 - divid;
            neg = !neg;
        }
        if (divis < 0) {
            divis = 0 - divis;
            neg = !neg;
        }
        if (divis > divid) {
            return 0;
        }
        int offset = 0;
        while ((divis<<1) <= divid) {
            divis <<= 1;
            offset++;
        }
        long result = 0;
        while (offset >= 0) {
            if (divid >= divis) {
                result |= (1<<offset);
                divid -= divis;
            }
            offset--;
            divis >>= 1;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)(neg? 0 - result : result);
    }
}
