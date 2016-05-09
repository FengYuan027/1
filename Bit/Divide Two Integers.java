/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative = false;
        long dividendL = dividend, divisorL = divisor;
        if (dividendL < 0) {
            negative = true;
            dividendL = (~dividendL) + 1;
        }
        if (divisorL < 0) {
            negative = !negative;
            divisorL = (~divisorL) + 1;
        }
        if (divisorL > dividendL) return 0;
        int offset = 1;
        while ((divisorL << offset) <= dividendL) offset++;
        long result = 0;
        while (offset >= 0) {
            if (dividendL >= (divisorL << offset)) {
                result |= (1<<offset);
                dividendL -= (divisorL << offset);
            }
            offset--;
        }
        return (int)(negative? (~result) + 1 : result);
    }
}
