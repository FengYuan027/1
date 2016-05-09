/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

public class Solution1 {
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        int slow = n, fast = next(n);
        while (slow != fast) {
            slow = next(slow);
            fast = next(next(fast));
        }
        return slow == 1;
    }
    
    private int next(int n) {
        int happy = 0;
        while (n > 0) {
            happy += (n%10)*(n%10);
            n /= 10;
        }
        return happy;
    }
}

public class Solution2 {
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        while (set.add(n)) {
            int next = 0;
            while (n > 0) {
                next += (n%10) * (n%10);
                n /= 10;
            }
            if (next == 1) return true;
            else n = next;
        }
        return false;
    }
}
