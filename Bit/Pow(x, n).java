/*
Implement pow(x, n).
*/

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (x == 0.0) return 0.0;
        boolean negative = false;
        if (n < 0) {
            negative = true;
            n = -n;
        }
        double result = 1.0, current = x;
        int index = 1;
        while (n != 0) {
            if ((index&n) != 0){
                result *= current;
                n ^= index;
            }
            current *= current;
            index <<= 1;
        }
        return negative ? 1 / result : result;
    }
}
