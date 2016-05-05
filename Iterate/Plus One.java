/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution1 {
    public int[] plusOne(int[] digits) {
        int[] plus = digits.clone();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (plus[i] == 9) plus[i] = 0;
            else {
                plus[i]++;
                return plus;
            }
        }
        plus = new int[digits.length + 1];
        plus[0] = 1;
        return plus;
    }
}

public class Solution2 {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        int carry = 1;
        while (carry > 0 && index >= 0) {
            carry = (digits[index] + 1)/10;
            index--;
        }
        int[] result = null;
        if (carry == 1) {
            result = new int[digits.length + 1];
            result[0] = 1;
        }
        else {
            result = new int[digits.length];
            for (int i = 0; i <= index; i++) {
                result[i] = digits[i];
            }
            result[index+1] = (digits[index+1] + 1)%10;
        }
        return result;
    }
}
