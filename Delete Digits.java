public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if (k == 0) {
            return new String(A);
        }
        if (k == A.length()) {
            return "";
        }
        char c = A.charAt(0);
        int index = 0;
        for (int i = 1; i <= k; i++) {
            if (A.charAt(i) < c) {
                c = A.charAt(i);
                index = i;
            }
        }
        String result = (c == '0' ? "":c) + DeleteDigits(A.substring(index+1), k - index);
        return result;
    }
}
