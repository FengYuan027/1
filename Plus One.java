public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        if (digits == null || digits.length == 0) {
            return null;
        }
        int[] plus = new int[digits.length + 1];
        int index = 0, carry = 1, N = digits.length;
        while (index < N || carry > 0) {
            int sum = (index == N ? 0 : digits[N - index - 1]) + carry;
            plus[index++] = sum % 10;
            carry = sum / 10;
        }
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = plus[index - i - 1];
        }
        return result;
    }
}
