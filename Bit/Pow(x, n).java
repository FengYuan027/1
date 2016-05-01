/*
Implement pow(x, n).
*/

public class Solution1 {
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

public class Solution2 {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (x == 0.0) return 0.0;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n%2 == 0 ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }
}

class Solution3 {
    double myPow(double x, int n) { 
        if(n==0) return 1;
        if(n<0) {
            n = -n;
            x = 1/x;
        }
        double ans = 1;
        while(n>0){
            if(n&1) ans *= x;
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}
